package com.example.newsapp_compose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp_compose.model.Article
import com.example.newsapp_compose.model.News
import com.example.newsapp_compose.repository.NewsRepository
import com.example.newsapp_compose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel(){

    var newsList = mutableStateOf<List<Article>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)


    init {
        loadNews()
    }

    fun loadNews(){
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getNews()
            when(result){
                is Resource.Success -> {
                    val article = result.data!!.articles
                    errorMessage.value = ""
                    isLoading.value = false
                    newsList.value = article
                }

                is Resource.Error ->{
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
            }
        }
    }
}