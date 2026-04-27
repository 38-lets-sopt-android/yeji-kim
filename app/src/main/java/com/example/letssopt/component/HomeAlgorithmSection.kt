package com.example.letssopt.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import com.example.letssopt.data.Content
import com.example.letssopt.ui.theme.MoreText

@Composable
fun RowItem(width: Dp, height: Dp, contents: List<Content>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(contents) { content ->
            Image(
                painter = painterResource(id = content.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillParentMaxWidth(0.3f)
                    .aspectRatio(2f / 3f)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun LazyList(
    contentsMiddleSection: List<Content>,
    contentsBottomSection: List<Content>,
    contentsTopSection: List<Content>,
    modifier: Modifier = Modifier
) {
    val pretendardSemiBold = FontFamily(Font(R.font.pretendard_semibold))

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(141414))
    ) {
        item {
            Column(modifier = Modifier) {
                Column(modifier = Modifier.padding(start = 19.dp, top = 24.dp, bottom = 14.dp)) {
                    Text(
                        "방금 막 도착한 신상 컨텐츠",
                        color = Color.White,
                        fontFamily = pretendardSemiBold,
                        fontSize = 20.sp
                    )
                    Text(
                        "예능부터 드라마까지!",
                        color = Color.Gray,
                        fontFamily = pretendardSemiBold,
                        fontSize = 16.sp
                    )
                }
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(contentsTopSection.take(3)) { content ->
                        Row(modifier = Modifier.fillParentMaxWidth(0.9f)) {
                            Image(
                                painter = painterResource(id = content.imageRes),
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
            Column(modifier = Modifier.padding(top = 10.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_watcha_algorithm),
                            contentDescription = "왓고리즘",
                            tint = Color.White
                        )
                        Text(
                            "예능부터 드라마까지!",
                            color = Color.Gray,
                            fontFamily = pretendardSemiBold,
                            fontSize = 12.sp
                        )
                    }
                    MoreText()
                }
                RowItem(width = 100.dp, height = 150.dp, contents = contentsMiddleSection)
            }
        }
        item {
            Column(modifier = Modifier.padding(top = 20.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        "공개 예정 콘텐츠 ",
                        color = Color.White,
                        fontFamily = pretendardSemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                    MoreText()
                }
                RowItem(width = 100.dp, height = 150.dp, contents = contentsMiddleSection)
            }
        }
        item {
            Column(modifier = Modifier.padding(top = 20.dp, bottom = 40.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        "왓챠 파티",
                        color = Color.White,
                        fontFamily = pretendardSemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                    MoreText()
                }
                RowItem(width = 196.dp, height = 185.dp, contents = contentsBottomSection)
            }
        }
        item {
            Column(modifier = Modifier.padding(top = 20.dp, bottom = 40.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        "왓챠 파티",
                        color = Color.White,
                        fontFamily = pretendardSemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                    MoreText()
                }

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(contentsBottomSection) { content ->
                        Column(
                            modifier = Modifier
                                .width(220.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF1A1A1A))
                        ) {
                            Image(
                                painter = painterResource(id = content.imageRes),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp),
                                contentScale = ContentScale.Crop
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_notification),
                                contentDescription = "알림",
                                tint = Color.White
                            )
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    "오늘 21:13에 시작",
                                    color = Color(0xFFFF2F55),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("# ${content.title}", color = Color.White, fontSize = 14.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}