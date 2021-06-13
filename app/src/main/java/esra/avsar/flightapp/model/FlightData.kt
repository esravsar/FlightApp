package esra.avsar.flightapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlightData (
    @SerializedName("data")
    var data : List<Data>?
) : Parcelable