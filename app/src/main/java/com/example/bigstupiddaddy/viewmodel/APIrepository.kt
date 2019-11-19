package com.example.bigstupiddaddy.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bigstupiddaddy.Model.Gif
import com.example.bigstupiddaddy.Model.GifResponse
import com.example.bigstupiddaddy.Network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIrepository {

    class ApiRepository(context: Context) {
        private val giphyService: Api = Api.create(context)

        fun getRandomGif(tag: String): LiveData<Gif> {
            val data = MutableLiveData<Gif>()

            giphyService.getRandomGif(tag, "pg", API_KEY).enqueue(object : Callback<GifResponse> {
                override fun onResponse(call: Call<GifResponse>, response: Response<GifResponse>) {
                    data.value = response.body()?.data
                }

                override fun onFailure(call: Call<GifResponse>, t: Throwable) {
                }
            })

            return data
        }

        companion object {
            private const val API_KEY = "FdwQn6t4H3vTDGYFGq2z5qZqJ1CMAf7C"
        }
    }
}