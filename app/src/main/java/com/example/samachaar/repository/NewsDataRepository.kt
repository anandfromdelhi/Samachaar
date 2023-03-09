package com.example.samachaar.repository

import com.example.samachaar.data.DataOrException
import com.example.samachaar.model.NewsDataClass
import com.example.samachaar.network.ApiInterface
import javax.inject.Inject

class NewsDataRepository @Inject constructor(
    private val api: ApiInterface
) {
    suspend fun getNewsData(country: String)
            : DataOrException<NewsDataClass, Boolean, Exception> {
        val response = try {
            api.getNewsData(country = country)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }
}