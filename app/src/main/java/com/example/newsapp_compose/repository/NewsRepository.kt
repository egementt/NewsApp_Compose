package com.example.newsapp_compose.repository

import com.example.newsapp_compose.model.News
import com.example.newsapp_compose.service.NewsAPI
import com.example.newsapp_compose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class NewsRepository @Inject constructor(
    private val api: NewsAPI
) {

    suspend fun getNews() : Resource<News> {
        val response = try {
            api.getNews()
        }catch (e: Exception){
            return Resource.Error("Can not fetch data.")
        }
        return  Resource.Success(response)
    }

    suspend fun searchCrypto(key: String) : Resource<News> {
        val response = try {
            api.searchNews(key)
        }catch (e: Exception){
            return Resource.Error("Not found any news about $key")
        }
        return Resource.Success(response)
    }
}