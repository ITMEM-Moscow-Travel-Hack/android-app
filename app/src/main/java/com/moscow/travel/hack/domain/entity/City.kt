package com.moscow.travel.hack.domain.entity

import com.google.gson.annotations.SerializedName

data class City(
    val id: String,
    @SerializedName("title") val name: String,
    @SerializedName("img") val photoUri: String,
    @SerializedName("short_description") val description: String
)
