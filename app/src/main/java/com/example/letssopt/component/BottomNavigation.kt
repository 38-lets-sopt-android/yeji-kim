package com.example.letssopt.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun BottomNavigation(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(containerColor = Color.Black) {
        val items = listOf("메인", "개별구매", "웹툰", "찾기", "보관함")
        val icons = listOf(
            Icons.Default.Home,
            Icons.Default.ShoppingCart,
            Icons.Default.Star,
            Icons.Default.Search,
            Icons.Default.Person
        )

        items.forEachIndexed { index, title ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = title,
                        tint = Color(0xFF333333)
                    )
                },
                label = {
                    Text(title, color = if (selectedTabIndex == index) Color.White else Color.Gray)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}