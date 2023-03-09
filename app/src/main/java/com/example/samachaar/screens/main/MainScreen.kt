package com.example.samachaar.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.samachaar.data.DataOrException
import com.example.samachaar.model.NewsDataClass
import com.example.samachaar.screens.main.MainScreenViewModel
import com.example.samachaar.utils.NewsCard

@Composable
fun MainScreen(

    navController: NavController,
    mainScreenViewModel: MainScreenViewModel = hiltViewModel(),
    countryCode: String?
) {
    val newsData =
        produceState<DataOrException<NewsDataClass, Boolean, Exception>>(
            initialValue = DataOrException()
        ) {
            value = mainScreenViewModel.getNewsData(country = countryCode.toString())
        }.value

    var isLoading by remember {
        mutableStateOf(true)
    }


    if (isLoading) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator()
        }
    }
    if (newsData.data != null) {
        isLoading = false

        val data = newsData.data!!.articles[0]
        NewsCard(
            modifier = Modifier,
            data = newsData.data!!
        )
    }
}



