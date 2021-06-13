package esra.avsar.flightapp.network.service

import esra.avsar.flightapp.model.FlightData
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightService {
    @GET("flights")
    suspend fun getFlights(@Query("access_key") accessKey : String) : FlightData?
}