package com.example.rss

import android.os.Parcel
import android.os.Parcelable

class RSSItem(val titleItem: String, val desItem: String, val pubDateItem: String, val colorItem: Int) : Parcelable {
    var title: String = titleItem
    var description: String = desItem
    var pubDate: String = pubDateItem
    var color: Int = colorItem

    private constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
        title = parcel.readString().toString()
        description = parcel.readString().toString()
        pubDate = parcel.readString().toString()
        color = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titleItem)
        parcel.writeString(desItem)
        parcel.writeString(pubDateItem)
        parcel.writeInt(colorItem)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(pubDate)
        parcel.writeInt(color)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RSSItem> {
        override fun createFromParcel(parcel: Parcel): RSSItem {
            return RSSItem(parcel)
        }

        override fun newArray(size: Int): Array<RSSItem?> {
            return arrayOfNulls(size)
        }
    }


}