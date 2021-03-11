package com.example.rss

import android.os.AsyncTask
import android.util.Log
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.lang.Exception
import java.net.URL
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class RSSTask(): AsyncTask<String, Void, NodeList>() {
    private val NAME_RSS_ITEM: String = "title"
    private val LINK_RSS_ITEM: String = "link"
    private val DESCRIPTION_RSS_ITEM: String = "description"
    private val DATE_RSS_ITEM: String = "pubDate"
    override fun doInBackground(vararg p0: String?): NodeList {
        val url: URL = URL(p0[0].toString())
        var itemNodeList: NodeList? = null
        try {
            val dbf: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
            val db: DocumentBuilder = dbf.newDocumentBuilder()
            val doc: Document = db.parse(InputSource(url.openStream()))
            doc.documentElement.normalize()
            itemNodeList = doc.documentElement.getElementsByTagName("item")
        } catch (e: Exception) {
            Log.e("Error", e.toString())
        }

        return itemNodeList!!
    }

    override fun onPostExecute(itemNodeList: NodeList) {
        try {
            for (item: Int in 0 until itemNodeList.length) {
                val itemNode: Node = itemNodeList.item(item)
                val itemElement: Element = itemNode as Element

                val titleItemNodeList: NodeList = itemElement.getElementsByTagName(NAME_RSS_ITEM)
                val linkItemNodeList: NodeList = itemElement.getElementsByTagName(LINK_RSS_ITEM)
                val desItemNodeList: NodeList = itemElement.getElementsByTagName(DESCRIPTION_RSS_ITEM)
                val dateItemNodeList: NodeList = itemElement.getElementsByTagName(DATE_RSS_ITEM)

                for (childItem: Int in 0 until titleItemNodeList.length) {
                    RSSData.addNewItem(RSSItem(titleItemNodeList.item(childItem).textContent,
                    linkItemNodeList.item(childItem).textContent, desItemNodeList.item(childItem).textContent,
                    dateItemNodeList.item(childItem).textContent))
                }
            }

            RSSData.recyclerView?.adapter = RSSAdapter(RSSData.rssItemMutableList)
        } catch (e: Exception) {
            Log.e("Error", e.toString())
        }

    }

}
