package com.yggdralisk.koinspotifysample.data.model

import android.os.Parcel
import android.os.Parcelable

data class Image(
        val height: Int,
        val url: String,
        val width: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(height)
        parcel.writeString(url)
        parcel.writeInt(width)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(parcel: Parcel): Image = Image(parcel)

        override fun newArray(size: Int): Array<Image?> = arrayOfNulls(size)
    }
}