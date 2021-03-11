package com.example.rss

import android.view.View

interface ItemsClickListener {
    fun click(pos: Int, v: View)
}