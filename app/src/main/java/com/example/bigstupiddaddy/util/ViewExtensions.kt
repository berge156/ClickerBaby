package com.example.bigstupiddaddy.util

import android.view.View


// this does the view of the photo that pops up. This makes it invisable

fun View.toggleVisibility(){
    visibility = if (visibility == View.VISIBLE) {View.INVISIBLE } else {View.VISIBLE}
}

// This makes the photo dissapear
fun View.dissapear() {
    visibility = if (visibility == View.VISIBLE) { View.GONE }
    else{ View.VISIBLE}
}