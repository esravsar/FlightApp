package esra.avsar.flightapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Flight (
    @SerializedName("number")
    var number: String?,
    @SerializedName("iata")
    var iata: String?,
    @SerializedName("icao")
    var icao: String?
) : Parcelable