package com.moscow.travel.hack.data.dto

import com.google.gson.annotations.SerializedName

data class CategoriesRequest(
    @SerializedName("user_token") val userToken: String,
    @SerializedName("categories") val categories: List<String>
)