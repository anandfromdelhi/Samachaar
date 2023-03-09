package com.example.samachaar.screens.main

import androidx.lifecycle.ViewModel
import com.example.samachaar.data.DataOrException
import com.example.samachaar.model.NewsDataClass
import com.example.samachaar.repository.NewsDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: NewsDataRepository
):ViewModel() {
    suspend fun getNewsData(country:String):DataOrException<NewsDataClass,Boolean,Exception>{
        return repository.getNewsData(country = country)
    }
}