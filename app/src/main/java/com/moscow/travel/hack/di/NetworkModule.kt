package com.moscow.travel.hack.di

import com.moscow.travel.hack.BASE_URL
import com.moscow.travel.hack.data.TrofikAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(
//                HttpLoggingInterceptor(::log).apply {
//                    level = HttpLoggingInterceptor.Level.BODY
//                }
//            )
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): TrofikAPI {
        return retrofit.create(TrofikAPI::class.java)
    }
}