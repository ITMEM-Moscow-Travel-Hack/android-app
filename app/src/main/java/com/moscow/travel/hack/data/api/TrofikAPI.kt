package com.moscow.travel.hack.data.api

import com.moscow.travel.hack.data.dto.request.CategoriesRequest
import com.moscow.travel.hack.data.dto.response.CitiesResponse
import com.moscow.travel.hack.data.dto.response.HotelsResponse
import com.moscow.travel.hack.data.dto.response.PlacesResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TrofikAPI {

    @POST("set_categories")
    suspend fun setCategories(
        @Body categoriesRequest: CategoriesRequest
    )

    @GET("/get_cities")
    suspend fun getCities(
        @Query("page") page: Int,
        @Query("offset") offset: Int,
    ): CitiesResponse

    @GET("/get_hotels")
    suspend fun getHotels(
        @Query("arrivalDate") startDate: String,
        @Query("departureDate") endDate: String,
        @Query("cityId") cityId: String,
        @Query("page") page: Int,
    ): HotelsResponse

    @GET("/get_cards")
    suspend fun getPlaces(
        @Body categoriesRequest: CategoriesRequest
    ): PlacesResponse
}