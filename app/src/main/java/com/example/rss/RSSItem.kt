package com.example.rss

class RSSItem(name: String, link: String, des: String, data: String) {
    var nameRssItem: String? = null
    var linkRssItem: String? = null
    var descriptionRssItem: String? = null
    var dateRSSItem: String? = null
    init {
        nameRssItem = name
        linkRssItem = link
        descriptionRssItem = des
        dateRSSItem = data
    }
}