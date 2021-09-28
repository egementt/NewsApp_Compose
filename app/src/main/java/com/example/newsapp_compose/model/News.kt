package com.example.newsapp_compose.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)