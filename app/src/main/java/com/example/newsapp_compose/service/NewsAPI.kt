package com.example.newsapp_compose.service

import com.example.newsapp_compose.model.News
import com.example.newsapp_compose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ): News

    @GET("everything")
    suspend fun searchNews(
        @Query("q") search: String ,
        @Query("sortBy") popularity: String = "popularity",
        @Query("page") page:Int = 1
    ): News
}