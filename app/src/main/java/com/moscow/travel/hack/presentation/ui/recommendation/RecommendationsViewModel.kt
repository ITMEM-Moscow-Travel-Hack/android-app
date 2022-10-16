package com.moscow.travel.hack.presentation.ui.recommendation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moscow.travel.hack.data.repository.MTHRepository
import com.moscow.travel.hack.domain.entity.City
import com.moscow.travel.hack.domain.entity.Hotel
import com.moscow.travel.hack.domain.entity.Place
import com.moscow.travel.hack.domain.entity.mockHotels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class RecommendationsViewModel @Inject constructor(
    private val repository: MTHRepository,
) : ViewModel() {

    var cities = mutableStateListOf<City>()
    var places = mutableStateListOf<Place>()
    var hotels = mutableStateListOf<Hotel>()

    var startDate by mutableStateOf<Date?>(null)
    var endDate by mutableStateOf<Date?>(null)

    var selectedCity by mutableStateOf<City?>(null)
    var selectedHotel by mutableStateOf<Hotel?>(null)
    var selectedPlaces = mutableStateListOf<Place>()

    init {
        fetchCities()
    }

    val selectedSum: Float
        get() {
            var ans = selectedHotel?.price ?: 0f
            for (place in selectedPlaces) {
                ans += place.price
            }
            return ans
        }

    fun resetAll() {
        selectedCity = null
        selectedHotel = null
        startDate = null
        endDate = null
        selectedPlaces = mutableStateListOf()
    }

    fun fetchCities() {
        cities.clear()
        viewModelScope.launch {
            val result = repository.getCities(0)
            if (result.isSuccess) {
                cities.addAll(result.getOrThrow())
            }
        }
    }

    fun fetchHotels() {
        hotels.clear()
        viewModelScope.launch {
            val result = repository.getHotels(startDate!!, endDate!!, selectedCity!!.id, 1)
            if (result.isSuccess) {
                hotels.addAll(result.getOrThrow())
            } else {
                hotels.addAll(mockHotels)
            }
        }
    }

    fun fetchPlaces() {
        places.clear()
        viewModelScope.launch {
            val result = repository.getPlaces()
            if (result.isSuccess) {
                places.addAll(result.getOrThrow())
            }
        }
    }
}