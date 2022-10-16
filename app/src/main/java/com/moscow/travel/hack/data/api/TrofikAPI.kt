package com.moscow.travel.hack.data.api

import com.moscow.travel.hack.data.dto.CategoriesRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface TrofikAPI {

    @POST("set_categories")
    suspend fun setCategories(
        @Body categoriesRequest: CategoriesRequest
    )
}