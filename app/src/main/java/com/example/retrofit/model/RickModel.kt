package com.example.retrofit.model

import com.google.gson.annotations.SerializedName

data class RickModel(
    @SerializedName("results")
    val results: List<RickData>
)

data class RickData(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("species")
    val species : String
)
