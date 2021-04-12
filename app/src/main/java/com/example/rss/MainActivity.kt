package com.example.rss

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        RSSData.context = this

        RSSThread().startThread(Constant.MEDUZA_URL.value)
        val rssData: RSSData.Companion = RSSData

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_rss_item)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RSSAdapter(RSSData.rssItemMutableList)
        }

        rssData.myItemsClickListener = object : ItemsClickListener {
            override fun click(pos: Int, v: View) {
                val intent: Intent = Intent(this@MainActivity, DetailsRSSItemActivity::class.java)
                intent.putExtra(Constant.KEY_INTENT.value, RSSData.rssItemMutableList[pos])
                startActivity(intent)
            }
        }

    }

}



