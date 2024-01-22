package com.example.punkapibeer.network

 import com.example.punkapibeer.models.BeerModel
import retrofit2.Response
import retrofit2.http.GET
 import retrofit2.http.Query

interface ApiBeer {

    @GET("beers")
    suspend fun obtenerBeerByName(@Query("beer_name") beerNameSearched: String): Response<List<BeerModel>>
}