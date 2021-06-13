package esra.avsar.flightapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import esra.avsar.flightapp.databinding.ActivityDetailBinding
import esra.avsar.flightapp.model.Data
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val flight = intent?.getParcelableExtra<Data?>("flight")


        binding.tvDepartureCode.text = flight?.departure?.iata
        binding.tvDepartureName.text = flight?.departure?.airport
        binding.tvDepartureDate.text = flight?.departure?.estimated?.let {
            DateFormat(
                "EEE, MMM d\nHH:mm", it
            )
        }

        binding.tvArrivalCode.text = flight?.arrival?.iata
        binding.tvArrivalName.text = flight?.arrival?.airport
        binding.tvArrivalDate.text = flight?.arrival?.estimated?.let {
            DateFormat(
                "EEE, MMM d\nHH:mm", it
            )
        }

        binding.tvFlight.text = flight?.flight?.iata
        binding.tvGate.text = flight?.departure?.gate
        binding.tvTerminal.text = flight?.departure?.terminal
        binding.tvDelay.text = flight?.departure?.delay.toString()

        binding.ivDetailCancel.setOnClickListener {
            finish()
        }
    }

    fun DateFormat(format: String, date: String?): String? {
        return try {
            val date= SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ", Locale.ENGLISH).parse(date.toString())
            val formattedDate = SimpleDateFormat(format, Locale.ENGLISH)
            (formattedDate.format(date.time))
        } catch (e: Exception) {
            null
        }
    }
}