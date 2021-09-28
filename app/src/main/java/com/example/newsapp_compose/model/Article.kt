package com.example.newsapp_compose.model

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source? = null,
    val title: String = "",
    val url: String = "",
    val urlToImage: String
)