package com.moscow.travel.hack.data.dto.response

import com.google.gson.annotations.SerializedName
import com.moscow.travel.hack.domain.entity.Hotel

data class HotelsResponse(
    @SerializedName("items") val hotels: List<Hotel>
)
