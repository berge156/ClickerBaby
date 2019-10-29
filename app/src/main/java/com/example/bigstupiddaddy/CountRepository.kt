package com.example.bigstupiddaddy

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import me.ibrahimsn.library.LiveSharedPreferences

//Creating the Repository
class CountRepository(context: Context) {
    private val preferences: SharedPreferences
    private val liveSharedPreferences: LiveSharedPreferences

    init {
        preferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        liveSharedPreferences = LiveSharedPreferences(preferences)
    }
// Sets the userCount
    fun setUserCount(name: String, count: Long) {
        preferences.edit().putLong(name, count).apply()
    }

    // Gets the User Count if they have a score
    fun getUserCount(name: String): LiveData<Long> =
        Transformations.map(liveSharedPreferences.listenMultiple(listOf(name), 0L)) { it[name] }

    //Click Counts
    companion object {
        private const val PREFS = "clickCounts"
    }
}