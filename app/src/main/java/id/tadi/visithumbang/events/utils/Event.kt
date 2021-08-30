package id.tadi.visithumbang.events.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    val eventName : String?,
    val eventDate : String?,
    val eventPoster : String?,
    val eventDescription : String?,
    val eventLocation : String?
) : Parcelable