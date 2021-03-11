package com.example.rss

import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.lang.Exception
import java.net.URL
import java.time.LocalDate
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rssData: RSSData.Companion = RSSData

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_rss_item)
        rssData.recyclerView = recyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        RSSTask().execute("https://meduza.io/rss2/all")

        rssData.myItemsClickListener = object : ItemsClickListener {
            override fun click(pos: Int, v: View) {
                val intent: Intent = Intent(this@MainActivity, ExtendedRSSActivity::class.java)
                rssData.apply {
                    rssExtendedDateItem = rssItemMutableList[pos].dateRSSItem
                    rssExtendedNameItem = rssItemMutableList[pos].nameRssItem
                    rssExtendedDesItem = rssItemMutableList[pos].descriptionRssItem
                    rssExtendedLinkItem = rssItemMutableList[pos].linkRssItem
                }
                startActivity(intent)
            }
        }

    }

}



