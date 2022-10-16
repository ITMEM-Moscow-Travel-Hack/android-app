package com.moscow.travel.hack.data.dto.response

import com.google.gson.annotations.SerializedName
import com.moscow.travel.hack.domain.entity.Place

data class PlacesResponse(
    @SerializedName("items") val places: List<Place>
)