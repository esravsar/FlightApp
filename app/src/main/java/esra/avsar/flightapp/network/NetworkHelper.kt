package esra.avsar.flightapp.network

import esra.avsar.flightapp.BuildConfig
import esra.avsar.flightapp.network.service.FlightService
import esra.avsar.flightapp.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkHelper {

    val flightService: FlightService
    private val baseurl = Constants.baseURL

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseurl)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        flightService = retrofit.create(FlightService::class.java)
    }

    private fun getClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.writeTimeout(60, TimeUnit.SECONDS)
        httpClient.addInterceptor(createHttpLoggingInterceptor(BuildConfig.DEBUG))
        return httpClient.build()
    }

    private fun createHttpLoggingInterceptor(debugMode: Boolean): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (debugMode) httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        else httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }
}