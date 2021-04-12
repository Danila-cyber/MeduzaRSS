package com.example.rss

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class DetailsRSSItemActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_rss_item)
        supportActionBar?.hide()

        val extendedTitleTextView: TextView = findViewById(R.id.textview_extended_title_item)
        val extendedDesTextView: TextView = findViewById(R.id.textview_extended_description_item)
        val extendedPubDateTextView: TextView = findViewById(R.id.textview_extended_date_item)
        val backgroundTitle: ConstraintLayout = findViewById(R.id.background_title)

        val rssItem: RSSItem? = intent.getParcelableExtra(Constant.KEY_INTENT.value)

        extendedTitleTextView.text = rssItem?.title
        extendedDesTextView.text = rssItem?.description
        extendedPubDateTextView.text = rssItem?.pubDate
        backgroundTitle.setBackgroundColor(rssItem?.color!!)

    }
}
