package com.yggdralisk.koinspotifysample.data.model

import android.os.Parcel
import android.os.Parcelable

data class Artist(
        val external_urls: ExternalUrls,
        val href: String,
        val id: String,
        val name: String,
        val type: String,
        val uri: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(ExternalUrls::class.java.classLoader),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(external_urls, flags)
        parcel.writeString(href)
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(type)
        parcel.writeString(uri)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Artist> {
        override fun createFromParcel(parcel: Parcel): Artist = Artist(parcel)

        override fun newArray(size: Int): Array<Artist?> = arrayOfNulls(size)
    }
}