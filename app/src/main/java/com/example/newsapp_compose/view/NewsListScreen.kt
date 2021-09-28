package com.example.newsapp_compose.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.newsapp_compose.model.Article
import com.example.newsapp_compose.ui.theme.*
import com.example.newsapp_compose.util.Constants.LOG
import com.example.newsapp_compose.viewmodel.NewsViewModel

@SuppressLint("LogNotTimber")
@Composable
fun NewsListScreen(
    navController: NavHostController,
    viewModel: NewsViewModel = hiltViewModel()
) {

    Scaffold(

        topBar = {
            TopAppBar(
                backgroundColor = darkThemeBlack,
                title = {
                    Text(
                        text = "News App",
                        color = darkThemeWhite,

                        )
                },
                elevation = 8.dp
            )
        }
    ) {
        Surface(
            Modifier.fillMaxSize(),
            color = darkThemeGray
        ) {
            Column() {
                NewsCard(
                    article = Article(
                        "Karla Adam",
                        title = "British troops on standby as truck driver crisis deepens, and people 'panic-buy' fuel",
                        content = "The British government put army drivers on standby Sept. 28, to help deliver fuel as pumps ran dry at gas stations throughout the country.",
                        description = "Brexit and the coronavirus pandemic are being blamed for widespread shortages across the country.",
                        publishedAt = "2021-09-28T16:41:55Z",
                        urlToImage = "https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/L5RMC6BALII6ZM6WRTPL4YGT4I.jpg&w=1440"
                    )
                )

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsCardPreview() {
}

@Composable
fun NewsCard(article: Article) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(220.dp)
            .padding(vertical = 12.dp, horizontal = 8.dp)
            .shadow(4.dp, Shapes.large, true)
            .background(color = darkThemeBlack, shape = Shapes.large)
    ) {
        Row(
            Modifier
                .wrapContentSize()
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(0.35f)
                    .background(Color.White, Shapes.large)

            ) {
                Image(
                    painter = rememberImagePainter(data = article.urlToImage),
                    contentDescription = "news image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(Shapes.large),
                    contentScale = ContentScale.Crop
                ) 
            }
            Column(Modifier.fillMaxSize().padding(vertical = 4.dp, horizontal = 8.dp), verticalArrangement = Arrangement.SpaceBetween) {
                Text(text = article.title, color = darkThemeTeal, style = MaterialTheme.typography.subtitle1, modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.W800, textAlign = TextAlign.Left)
                Text(text = article.content, color = darkThemeWhite, style = MaterialTheme.typography.caption, modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Light, textAlign = TextAlign.Justify)
                Text(text = "by ${article.author}", color = darkThemeTeal, style = MaterialTheme.typography.caption, modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.SemiBold, textAlign = TextAlign.End)
                Text(text = "at ${article.publishedAt}", color = darkThemeTeal, style = MaterialTheme.typography.caption, modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.SemiBold, textAlign = TextAlign.End)
            }
        }

    }
}


