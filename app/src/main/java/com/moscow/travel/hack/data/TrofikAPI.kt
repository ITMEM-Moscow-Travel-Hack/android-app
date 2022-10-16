package com.moscow.travel.hack.data

import retrofit2.http.Body
import retrofit2.http.POST

interface TrofikAPI {
    @POST("/set_categories")
    suspend fun login(
        @Body user: UserLoginRequest
    )
}