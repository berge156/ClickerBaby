package com.example.bigstupiddaddy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bigstupiddaddy.Network.APIgiphy

class APIrepository {

    private val Giffy: APIgiphy = APIgiphy.create()

    fun getGif():LiveData<Gif> {
        val data = MutableLiveData<Gif>

    }
}