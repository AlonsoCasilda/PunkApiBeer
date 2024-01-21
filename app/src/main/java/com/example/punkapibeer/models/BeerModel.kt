package com.example.punkapibeer.models

import com.google.gson.annotations.SerializedName

data class BeerModel (

    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image_url")
    val image: String,

)
