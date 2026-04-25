package com.example.letssopt.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.R
import com.example.letssopt.ui.theme.MoreText

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
            Column {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        "방금 막 도착한 신상 컨텐츠",
                        color = Color.White,
                        fontFamily = pretendardSemiBold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 19.dp, top = 24.dp),
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        "예능부터 드라마까지!",
                        color = Color.Gray,
                        fontFamily = pretendardSemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 19.dp)
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                }
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(viewModel.movies3.take(3)) { movie ->
                        Row(modifier = Modifier.fillParentMaxWidth(0.9f)) {
                            Image(
                                painter = painterResource(id = movie.imageRes),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .aspectRatio(7f / 4f)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(Modifier.height(4.dp))
                        }
                    }
                }
            }
        }
        item {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "왓고리즘", color = Color.White, fontFamily = pretendardSemiBold,
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .size(width = 80.dp, height = 26.dp)
                        )
                        Text(
                            "예능부터 드라마까지!", color = Color.Gray, fontFamily = pretendardSemiBold,
                            modifier = Modifier
                                .padding(bottom = 3.dp)
                                .size(width = 170.dp, height = 25.dp)

                        )
                    }
                    MoreText()
                }
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(viewModel.movies) { movie ->
                        Image(
                            painter = painterResource(id = movie.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 150.dp)
                                .background(Color.DarkGray)
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
        item {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        "공개 예정 콘텐츠 ", color = Color.White, fontFamily = pretendardSemiBold,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .size(width = 131.dp, height = 24.dp)
                    )
                    Box(modifier = Modifier.fillMaxWidth()) {
                        MoreText(modifier = Modifier.align(Alignment.CenterEnd))
                    }
                }
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(viewModel.movies) { movie ->
                        Image(
                            painter = painterResource(id = movie.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp, 150.dp)
                                .background(Color.DarkGray)
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
        item {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        "왓챠 파티", color = Color.White, fontFamily = pretendardSemiBold,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .size(width = 74.dp, height = 24.dp)
                    )
                    Box(modifier = Modifier.fillMaxWidth()) {
                        MoreText(modifier = Modifier.align(Alignment.CenterEnd))
                    }
                }
                LazyRow {
                    items(viewModel.movies2) { movie ->
                        Image(
                            painter = painterResource(id = movie.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(width = 196.dp, height = 185.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}