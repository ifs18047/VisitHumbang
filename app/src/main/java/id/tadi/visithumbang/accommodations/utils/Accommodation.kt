package id.tadi.visithumbang.accommodations.utils

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Accommodation(
    val accommodationName : String?,
    val accommodationPoster : String?,
    val accommodationLocation : String?,
    val accommodationAbout : String?,
    val accommodationStar : Int?
): Parcelable