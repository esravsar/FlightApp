package esra.avsar.flightapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import esra.avsar.flightapp.adapter.FlightRecyclerAdapter
import esra.avsar.flightapp.databinding.ActivityHomeBinding
import esra.avsar.flightapp.ui.DetailActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = FlightRecyclerAdapter {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("flight", it)
            startActivity(intent)
        }
        binding.rvHomePage.layoutManager = LinearLayoutManager(this)
        binding.rvHomePage.adapter = adapter

        viewModel.flightsLiveData.observe(this) {
            Log.d("HomeActivity", "List ${it?.size}")
            adapter.updateItems(it)
        }
        viewModel.getFligths()
    }
}