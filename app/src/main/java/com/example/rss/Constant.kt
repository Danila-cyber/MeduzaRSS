package com.example.rss

enum class Constant(val value: String) {
    ITEM("item"), TITLE("title"),LINK("link"),DESCRIPTION("description"),
    PUB_DATE("pubDate"), MEDUZA_URL("https://meduza.io/rss2/all"),
    MAX_LENGTH_TITLE("30"), MAX_LENGTH_DES("40"),
    KEY_INTENT("DetailsRSSItem")
}