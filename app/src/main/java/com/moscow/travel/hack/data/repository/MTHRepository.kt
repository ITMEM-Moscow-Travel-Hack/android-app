package com.moscow.travel.hack.data.repository

import com.moscow.travel.hack.data.api.TrofikAPI
import com.moscow.travel.hack.data.dto.CategoriesRequest
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
}