package com.example.bigstupiddaddy.util

import android.view.View

fun View.toggleVisibility(){
    visibility = if (visibility == View.VISIBLE) {View.INVISIBLE } else {View.VISIBLE}
}