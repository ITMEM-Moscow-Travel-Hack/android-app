package com.moscow.travel.hack.data.dto.response

import com.google.gson.annotations.SerializedName
import com.moscow.travel.hack.domain.entity.City

data class CitiesResponse(
    @SerializedName("items") val cities: List<City>
)
