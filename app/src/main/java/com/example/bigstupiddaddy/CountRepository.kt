package com.example.bigstupiddaddy

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

class CountRepository(context: Context) {
    private val preferences: SharedPreferences
    private val liveSharedPreferences: LiveSharedPreferences

    init {
        preferences = contexxt.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        liveSharedPreferences = liveSharedPreferences(preferences)
    }

    fun setUserCount(name: Sting): LiveData<Long> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), OL)) {it[name]}

    companion object {
        private const val  PREFS = "clickCounts"
    }
}