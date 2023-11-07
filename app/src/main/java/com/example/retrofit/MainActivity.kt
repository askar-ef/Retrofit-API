package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.model.RickData
import com.example.retrofit.model.RickModel
import com.example.retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getRick()
        val rickNames = ArrayList<String>()

        response.enqueue(object: Callback<RickModel>
        {
            override fun onResponse(call: Call<RickModel>, response: Response<RickModel>) {
                val thisResponse = response.body()
                val datas = thisResponse?.results ?: emptyList()

                if(datas.isNotEmpty()){
                    for (i in datas){
                        rickNames.add(i.name)
                    }
                }

                val listAdapter = ArrayAdapter(
                    this@MainActivity, android.R.layout.simple_list_item_1, rickNames
                )
                binding.lvName.adapter = listAdapter
            }

            override fun onFailure(call: Call<RickModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Connection Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}