package com.example.letssopt.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.R

data class Movie(
    val title: String,
    val imageRes: Int
)

@Composable
fun LazyList(modifier: Modifier = Modifier) {
    val viewModel: MovieViewModel = viewModel()
    val pretendardSemiBold = FontFamily(Font(R.font.pretendard_semibold))

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        item {
            Text("방금 막 도착한 신상 컨텐츠", color = Color.White, fontFamily = pretendardSemiBold,
                modifier = Modifier
                .padding(top = 5.dp) // 얘네 좀 늘려봐야 할 듯
                .size(width = 210.dp, height = 24.dp))
            Text("예능부터 드라마까지!", color = Color.Gray, fontFamily = pretendardSemiBold,
                modifier = Modifier
                .padding(top = 30.dp) // 얘네 좀 늘려봐야 할 듯
                .size(width = 150.dp, height = 15.dp))
            Image(
                painter = painterResource(id = R.drawable.crime),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 872.dp, height = 160.dp),
                contentScale = ContentScale.Crop
            )
        }
        item {
            Text("왓고리즘", color = Color.White, fontFamily = pretendardSemiBold,
                modifier = Modifier
                .padding(top = 5.dp)
                .size(width = 80.dp, height = 26.dp))
            Text("예능부터 드라마까지!", color = Color.Gray, fontFamily = pretendardSemiBold,
                modifier = Modifier
                .padding(bottom = 3.dp)
                .size(width = 170.dp, height = 25.dp))
            LazyRow {
                items(viewModel.movies) { movie ->
                    Column(modifier = Modifier.padding(5.dp)) {
                        Image(
                            painter = painterResource(id = movie.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 150.dp)
                                .background(Color.DarkGray),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
        item {
            Text("공개 예정 콘텐츠 ", color = Color.White, fontFamily = pretendardSemiBold,
                modifier = Modifier
                .padding(top = 5.dp)
                .size(width = 131.dp, height = 24.dp))
            LazyRow {
                items(viewModel.movies) { movie ->
                    Column(modifier = Modifier.padding(5.dp)) {
                        Image(
                            painter = painterResource(id = movie.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 150.dp)
                                .background(Color.DarkGray),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
        item {
            Text("왓챠 파티", color = Color.White, fontFamily = pretendardSemiBold,
                modifier = Modifier
                .padding(top = 5.dp)
                .size(width = 74.dp, height = 24.dp))
            LazyRow {
                items(viewModel.movies2) { movie ->
                    Column(modifier = Modifier.padding(5.dp)) {
                        Image(
                            painter = painterResource(id = movie.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(width = 196.dp, height = 185.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}