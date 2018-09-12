package com.yggdralisk.koinspotifysample.data.model

import android.os.Parcel
import android.os.Parcelable

data class ExternalUrls(
        val spotify: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) = parcel.writeString(spotify)

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ExternalUrls> {
        override fun createFromParcel(parcel: Parcel): ExternalUrls = ExternalUrls(parcel)
        override fun newArray(size: Int): Array<ExternalUrls?> = arrayOfNulls(size)
    }
}