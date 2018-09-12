package com.yggdralisk.koinspotifysample.data.model

import android.os.Parcel
import android.os.Parcelable

data class ReleaseModel(
        val album_type: String,
        val artists: List<Artist>,
        val available_markets: List<String>?,
        val external_urls: ExternalUrls,
        val href: String,
        val id: String,
        val images: List<Image>,
        val name: String,
        val release_date: String,
        val release_date_precision: String,
        val total_tracks: Int,
        val type: String,
        val uri: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.createTypedArrayList(Artist),
            parcel.createStringArrayList(),
            parcel.readParcelable(ExternalUrls::class.java.classLoader),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(Image),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(album_type)
        parcel.writeTypedList(artists)
        parcel.writeStringList(available_markets)
        parcel.writeParcelable(external_urls, flags)
        parcel.writeString(href)
        parcel.writeString(id)
        parcel.writeTypedList(images)
        parcel.writeString(name)
        parcel.writeString(release_date)
        parcel.writeString(release_date_precision)
        parcel.writeInt(total_tracks)
        parcel.writeString(type)
        parcel.writeString(uri)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ReleaseModel> {
        override fun createFromParcel(parcel: Parcel): ReleaseModel = ReleaseModel(parcel)

        override fun newArray(size: Int): Array<ReleaseModel?> = arrayOfNulls(size)
    }
}