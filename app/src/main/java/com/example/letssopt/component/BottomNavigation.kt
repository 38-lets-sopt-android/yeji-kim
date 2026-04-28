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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Main : BottomNavItem("main", "메인", Icons.Default.Home)
    object Purchase : BottomNavItem("buy", "개별구매", Icons.Default.ShoppingCart)
    object Webtoon : BottomNavItem("webtoon", "웹툰", Icons.Default.Star)
    object Search : BottomNavItem("search", "찾기", Icons.Default.Search)
    object My : BottomNavItem("my", "보관함", Icons.Default.Person)
}

@Composable
fun BottomNavigation(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
) {
    val navItems = listOf(
        BottomNavItem.Main,
        BottomNavItem.Purchase,
        BottomNavItem.Webtoon,
        BottomNavItem.Search,
        BottomNavItem.My
    )

    NavigationBar(containerColor = Color(0xFF141414)) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = Color(0xFF333333)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (selectedTabIndex == index) Color.White else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}