package com.example.bigstupiddaddy.Network

import android.content.Context
import com.example.bigstupiddaddy.Model.GifResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.OkHttpClient


interface APIgiphy {
    @GET("v1/gifs/random")
    fun getRandomGif(@Query("tag") tag: String,
                     @Query("rating") rating: String,
                     @Query("api_key") apiKey: String): Call<GifResponse>

    companion object{
        fun create(context: Context) : APIgiphy{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.giphy.com/")
                .build()

            return retrofit.create(APIgiphy::class.java)

        }
    }


}