package com.example.bigstupiddaddy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.bigstupiddaddy.APIrepository

class GifViewModel(application: Application) : AndroidViewModel(application){
    private val repository = APIrepository(application.applicationContext)

    fun getRandomGif(tag: String) = repository.getRandomGif(tag)

}