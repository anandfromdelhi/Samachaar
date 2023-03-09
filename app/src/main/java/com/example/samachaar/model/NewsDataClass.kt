package com.example.samachaar.model

data class NewsDataClass(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)