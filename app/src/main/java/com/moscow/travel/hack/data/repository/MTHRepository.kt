package com.moscow.travel.hack.data.repository

import com.moscow.travel.hack.data.api.TrofikAPI
import com.moscow.travel.hack.data.dto.request.CategoriesRequest
import com.moscow.travel.hack.domain.entity.City
import com.moscow.travel.hack.domain.entity.Hotel
import com.moscow.travel.hack.domain.entity.Place
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class MTHRepository @Inject constructor(
    private val api: TrofikAPI
) {

    suspend fun sendCategories(categoriesRequest: CategoriesRequest): Result<Unit> {
        return try {
            api.setCategories(categoriesRequest)
            Result.success(Unit)
        } catch (exc: Exception) {
            Result.failure(exc)
        }
    }

    suspend fun getCities(page: Int): Result<List<City>> {
        return try {
            val result = api.getCities(page, 20)
            Result.success(result.cities)
        } catch (exc: Exception) {
            Result.failure(exc)
        }
    }

    suspend fun getHotels(
        startDate: Date,
        endDate: Date,
        cityId: String,
        page: Int
    ): Result<List<Hotel>> {
        return try {
            val result = api.getHotels(
                startDate = SimpleDateFormat(
                    "YYYY-mm-dd",
                    Locale.getDefault()
                ).format(startDate),
                endDate = SimpleDateFormat(
                    "YYYY-mm-dd",
                    Locale.getDefault()
                ).format(endDate),
                cityId,
                page
            )
            Result.success(result.hotels)
        } catch (exc: Exception) {
            Result.failure(exc)
        }
    }

    suspend fun getPlaces(): Result<List<Place>> {
        return try {
            val result = api.getPlaces(CategoriesRequest("gtrhjgrbtjhgr", listOf()))
            Result.success(result.places)
        } catch (exc: Exception) {
            Result.failure(exc)
        }
    }
}