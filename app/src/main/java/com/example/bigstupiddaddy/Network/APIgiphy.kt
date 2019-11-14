package com.example.bigstupiddaddy.Network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface APIgiphy {
    @GET ("v1/gifs/random")
    fun getRandomGIF (@Query("tag") tag: String,
                      @Query("rating") rating: String,
                      @Query ("api_key") apiKey: String)

    companion object {
        fun create(): APIgiphy{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("api.giphy.com/")
                        .build()

                return retrofit.create(APIgiphy::class.java)
        }
    }
}