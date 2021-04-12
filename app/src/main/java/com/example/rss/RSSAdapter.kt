package com.example.rss

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rss.RSSAdapter.*

class RSSAdapter(private val values: MutableList<RSSItem>) : RecyclerView.Adapter<MyViewHolder>() {
    private val MAX_LENGTH_TITLE: Int = 30
    private val MAX_LENGTH_DES: Int = 45
    private fun cuttingString(str: String, mode: Int): String {
        return if (checkLength(str, mode)) str.replaceRange(mode until str.length, "...")
        else str
    }
    private val checkLength: (String, Int) -> Boolean = { str: String, mode: Int ->
         str.length > mode
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_layouts, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return values.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleRssItem.text =
            cuttingString(values[position].title, MAX_LENGTH_TITLE)
        holder.desRssItem.text =
            cuttingString(values[position].description, MAX_LENGTH_DES)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(p0: View) {
            RSSData.myItemsClickListener.click(adapterPosition, p0)
        }

        var titleRssItem: TextView
        var desRssItem: TextView

        init {
            itemView.apply {
                titleRssItem = findViewById(R.id.recyclerview_title_rss_item)
                desRssItem = findViewById(R.id.recyclerview_description_rss_item)

                setOnClickListener(this@MyViewHolder)
            }
        }
    }
}