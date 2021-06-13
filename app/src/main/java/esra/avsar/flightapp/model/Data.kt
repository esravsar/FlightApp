package esra.avsar.flightapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data (
    @SerializedName("flight_date")
    var flight_date: String?,
    @SerializedName("flight_status")
    var flight_status: String?,
    @SerializedName("airline")
    var airline: Airline?,
    @SerializedName("arrival")
    var arrival: Arrival?,
    @SerializedName("departure")
    var departure: Departure?,
    @SerializedName("flight")
    var flight: Flight?
) : Parcelable