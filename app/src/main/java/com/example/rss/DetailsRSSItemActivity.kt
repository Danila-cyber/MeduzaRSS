package com.example.rss

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class DetailsRSSItemActivity : AppCompatActivity() {
//    private val dayOfTheWeek: Map<Int, String> = mapOf(
//            0 to "Суббота",
//            1 to "Воскресенье",
//            2 to "Понедельник",
//            3 to "Вторник",
//            4 to "Среда",
//            5 to "Четверг",
//            6 to "Пятница"
//    )

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_rss_item)
        supportActionBar?.hide()

        val extendedTitleTextView: TextView = findViewById(R.id.textview_extended_title_item)
        val extendedDesTextView: TextView = findViewById(R.id.textview_extended_description_item)
        val extendedPubDateTextView: TextView = findViewById(R.id.textview_extended_date_item)
        val backgroundTitle: ConstraintLayout = findViewById(R.id.background_title)

        extendedTitleTextView.text = RSSData.extendedRssItem.title
        extendedDesTextView.text = RSSData.extendedRssItem.description

//        val dateFormat: SimpleDateFormat = SimpleDateFormat("E, DD MMM yyyy HH:MM:SS Z", Locale.ENGLISH)
//        val date: Date = dateFormat.parse(RSSData.extendedRssItem.pubDate)

        extendedPubDateTextView.text = RSSData.extendedRssItem.pubDate

        backgroundTitle.setBackgroundColor(RSSData.extendedRssItem.color)

    }
}
