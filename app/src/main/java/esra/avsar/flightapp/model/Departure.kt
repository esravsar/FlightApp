package esra.avsar.flightapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Departure (
    @SerializedName("airport")
    var airport: String?,
    @SerializedName("timezone")
    var timezone: String?,
    @SerializedName("iata")
    var iata: String?,
    @SerializedName("icao")
    var icao: String?,
    @SerializedName("terminal")
    var terminal: String?,
    @SerializedName("gate")
    var gate: String?,
    @SerializedName("delay")
    var delay: Int?,
    @SerializedName("scheduled")
    var scheduled: String?,
    @SerializedName("estimated")
    var estimated: String?
) : Parcelable