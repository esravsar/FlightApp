package esra.avsar.flightapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import esra.avsar.flightapp.model.Data
import esra.avsar.flightapp.network.NetworkHelper
import esra.avsar.flightapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _flightsLiveData = MutableLiveData<List<Data>?>()

    val flightsLiveData: LiveData<List<Data>?> get() = _flightsLiveData

    fun getFligths() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val networkHelper = NetworkHelper()
                val result = networkHelper.flightService.getFlights(Constants.apiKey)
                _flightsLiveData.postValue(result?.data)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}