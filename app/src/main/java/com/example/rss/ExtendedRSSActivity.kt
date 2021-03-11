package com.example.rss

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi

class ExtendedRSSActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extended_r_s_s)

        val rssData: RSSData.Companion = RSSData

        val extendedNameItemTextView: TextView = findViewById(R.id.textview_extended_name_item)
        extendedNameItemTextView.text = rssData.rssExtendedNameItem

        val extendedDesItemTextView: TextView = findViewById(R.id.textview_extended_description_item)
        extendedDesItemTextView.text = rssData.rssExtendedDesItem

        val extendedDateItemTextView: TextView = findViewById(R.id.textview_extended_date_item)
        extendedDateItemTextView.text = rssData.rssExtendedDateItem

        val extendedLinkItemTextView: TextView = findViewById(R.id.textview_extended_link_item)
        extendedLinkItemTextView.text = rssData.rssExtendedLinkItem

    }
}
