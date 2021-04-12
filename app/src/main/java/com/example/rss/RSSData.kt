package com.example.rss

import android.content.Context

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