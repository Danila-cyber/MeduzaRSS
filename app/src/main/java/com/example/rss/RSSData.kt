package com.example.rss

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

class RSSData{
    companion object {
        lateinit var context: Context

        lateinit var myItemsClickListener: ItemsClickListener
        lateinit var extendedRssItem: RSSItem

        var rssItemMutableList: MutableList<RSSItem> = mutableListOf()
        fun addNewItem(item: RSSItem) {
            rssItemMutableList.add(item)
        }

    }
}