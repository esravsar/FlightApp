package esra.avsar.flightapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import esra.avsar.flightapp.R
import esra.avsar.flightapp.databinding.ItemFlightBinding
import esra.avsar.flightapp.model.Data
import java.text.SimpleDateFormat
import java.util.*


class FlightRecyclerAdapter(private val onItemClickListener: (Data?) -> Unit) : RecyclerView.Adapter<FlightRecyclerAdapter.FlightViewHolder>() {

    private val flights = mutableListOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        return FlightViewHolder(
            ItemFlightBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun updateItems(flights: List<Data>?) {
        this.flights.clear()
        flights?.let {
            this.flights.addAll(it)
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(flights[position])
    }

    override fun getItemCount(): Int = flights.size

    inner class FlightViewHolder(
        private val binding: ItemFlightBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(flight: Data) {
            binding.tvAirport.text = flight.airline?.airlineName
            binding.tvDeparture.text = "${flight. departure?.iata} - ${DateFormat("HH:dd", flight?.departure?.estimated)}"
            binding.tvArrival.text = "${flight. arrival?.iata} - ${DateFormat("HH:dd", flight?.arrival?.estimated)}"
            binding.ivStatus.setImageResource(when(flight.flight_status) {
                "scheduled" -> R.drawable.ic_status_scheduled
                "cancelled" -> R.drawable.ic_status_cancelled
                else -> R.drawable.ic_status_active
            })

            binding.root.setOnClickListener{
                onItemClickListener.invoke(flight)
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
}


