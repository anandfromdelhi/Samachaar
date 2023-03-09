package com.example.samachaar.screens.selectCountry


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.samachaar.navigation.NewsScreens
import java.util.*


@Composable
fun selectCountry(
    selectCountryViewModel: SelectCountryViewModel = hiltViewModel(),
    navController: NavController
) {

    LazyColumn(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),

        ) {
        item {
            countryCard(country = "INDIA", navController, countryCode = "IN")
        }
        item {
            countryCard(country = "USA", navController, countryCode = "US")
        }
        item {
            countryCard(country = "CANADA", navController, countryCode = "CA")
        }
        item {
            countryCard(country = "ENGLAND", navController, countryCode = "GB")
        }
        item {
            countryCard(country = "SOUTH AFRICA", navController, countryCode = "ZA")
        }
        item {
            countryCard(country = "AUSTRALIA", navController, countryCode = "AU")
        }

        item {
            countryCard(country = "SOUTH KOREA", navController, countryCode = "kr")
        }
        item {
            countryCard(country = "NEW ZEALAND", navController, countryCode = "nz")
        }
        item {
            countryCard(country = "UAE", navController, countryCode = "AE")
        }
        item {
            countryCard(country = "SINGAPORE", navController, countryCode = "SG")
        }
        item {
            countryCard(country = "NORWAY", navController, countryCode = "no")
        }

    }

}


@Composable
fun countryCard(
    country: String,
    navController: NavController,
    countryCode: String
) {
    fun RandomColor(): androidx.compose.ui.graphics.Color {
        val random = Random(System.currentTimeMillis())
        return Color(
            red = random.nextFloat(),
            green = random.nextFloat(),
            blue = random.nextFloat(),
            alpha = 1f
        )
    }
    Row(
        modifier = Modifier
            .clickable {
                navController.navigate(
                    NewsScreens.NewsPage.name + "/$countryCode"
                )
            }
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(), elevation = 5.dp,
            color = RandomColor()
        ) {
            Text(
                text = country,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
            )
        }

    }
}