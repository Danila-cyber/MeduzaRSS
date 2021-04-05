package com.example.rss

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.lang.Math.floor
import java.net.URL
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

class RSSThread {
    private fun generateRandomColor(colorsArray: IntArray): Int {
        val randomColor: Int = kotlin.math.floor(Math.random() * colorsArray.size).toInt()
        return colorsArray[randomColor]

    }

    fun startThread(argUrl: String) {
        val thread: Thread = Thread(object : Runnable {
            override fun run() {
                val url: URL = URL(argUrl)
                val dbf: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
                val db: DocumentBuilder = dbf.newDocumentBuilder()
                val doc: Document = db.parse(InputSource(url.openStream()))
                doc.documentElement.normalize()
                val itemNodeList: NodeList = doc.documentElement.getElementsByTagName(Constant.ITEM.value)
                for (item: Int in 0 until itemNodeList.length) {
                    val itemNode: Node = itemNodeList.item(item)
                    val itemElem: Element = itemNode as Element

                    val titleNode: Node = itemElem.getElementsByTagName(Constant.TITLE.value).item(0)
                    val descriptionNode: Node = itemElem.getElementsByTagName(Constant.DESCRIPTION.value).item(0)
                    val pubDate: Node = itemElem.getElementsByTagName(Constant.PUB_DATE.value).item(0)
                    val colorTitle: Int = generateRandomColor(RSSData.context.resources.getIntArray(R.array.background_title_item))

                    val rssItem: RSSItem = RSSItem(title = titleNode.textContent, des = descriptionNode.textContent, pubDate = pubDate.textContent, color = colorTitle)
                    RSSData.addNewItem(rssItem)

                }
            }
        })
        thread.start()
        thread.join()

    }
}