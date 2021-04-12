package com.example.rss

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.net.URL
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.math.floor

class RSSThread {
    fun startThread(argUrl: String) {
        val thread: Thread = Thread(RSSRunnable(argUrl))
        thread.apply {
            start()
            join()
        }
    }
}

class RSSRunnable(private val argUrl: String) : Runnable {
    private val generateRandomColor = { colorsArray: IntArray ->
        colorsArray[(floor(Math.random() * colorsArray.size)).toInt()]
    }

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
            val descriptionNode: Node =
                itemElem.getElementsByTagName(Constant.DESCRIPTION.value).item(0)
            val pubDate: Node = itemElem.getElementsByTagName(Constant.PUB_DATE.value).item(0)
            val colorTitle: Int =
                generateRandomColor(RSSData.context.resources.getIntArray(R.array.backgrounds_title_item))

            val rssItem: RSSItem = RSSItem(
                titleItem = titleNode.textContent,
                desItem = descriptionNode.textContent,
                pubDateItem = pubDate.textContent,
                colorItem = colorTitle
            )
            RSSData.addNewItem(rssItem)
        }
    }
}