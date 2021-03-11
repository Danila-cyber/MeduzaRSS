package com.example.rss

import android.util.Log
import androidx.recyclerview.widget.RecyclerView

class RSSData {
    companion object {
        var myItemsClickListener: ItemsClickListener? = null

        var rssItemMutableList: MutableList<RSSItem> = mutableListOf()
        fun addNewItem(item: RSSItem) {
            rssItemMutableList.add(item)
        }

        var recyclerView: RecyclerView? = null

        var rssExtendedNameItem: String? = null
        var rssExtendedDesItem: String? = null
        var rssExtendedLinkItem: String? = null
        var rssExtendedDateItem: String? = null

    }
}