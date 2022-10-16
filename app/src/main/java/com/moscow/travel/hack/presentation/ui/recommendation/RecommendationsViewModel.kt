package com.moscow.travel.hack.presentation.ui.recommendation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.moscow.travel.hack.domain.entity.City
import com.moscow.travel.hack.domain.entity.Hotel
import com.moscow.travel.hack.domain.entity.Place
import java.util.Date

class RecommendationsViewModel : ViewModel() {

    var startDate by mutableStateOf<Date?>(null)
    var endDate by mutableStateOf<Date?>(null)

    var selectedCity by mutableStateOf<City?>(null)
    var selectedHotel by mutableStateOf<Hotel?>(null)
    var selectedPlaces = mutableStateListOf<Place>()

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
}