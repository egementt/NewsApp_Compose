package com.example.newsapp_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.newsapp_compose.ui.theme.NewsApp_ComposeTheme
import com.example.newsapp_compose.view.NewsDetailScreen
import com.example.newsapp_compose.view.NewsListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApp_ComposeTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "news_list_screen")
                {
                    composable("news_list_screen") {
                        NewsListScreen(navController)
                    }
                    composable("news_detail_screen/{newsUrl}", arguments = listOf(
                        navArgument("newsUrl") {
                            type = NavType.StringType
                        }
                    )) {
                        val newsUrl = remember {
                            it.arguments?.getString("cryptoId")
                        }
                        NewsDetailScreen(
                            url = newsUrl ?: "",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

