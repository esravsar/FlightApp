package esra.avsar.flightapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Airline (
    @SerializedName("name")
    var airlineName: String?,
    @SerializedName("iata")
    var airline_iata: String?,
    @SerializedName("icao")
    var airline_icao: String?
) : Parcelable