package com.example.retrofit.network


import com.example.retrofit.model.RickModel
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("character")
    fun getRick(): Call<RickModel>
}