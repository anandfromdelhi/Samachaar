package com.example.samachaar.network

import com.example.samachaar.model.NewsDataClass
import com.example.samachaar.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ApiInterface {
    @GET(value = "top-headlines")
    suspend fun getNewsData(
        @Query("country") country: String,
        @Query("apiKey")apiKey:String = Constants.API_KEY
    ):NewsDataClass
}