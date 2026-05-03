package com.example.letssopt.presentation.home.component

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
import com.example.letssopt.navigation.Route

sealed class BottomNavItem(
    val route: Any,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(Route.Home, "메인", Icons.Default.Home)
    object Purchase : BottomNavItem(Route.Purchase, "개별구매", Icons.Default.ShoppingCart)
    object Webtoon : BottomNavItem(Route.Webtoon, "웹툰", Icons.Default.Star)
    object Search : BottomNavItem(Route.Search, "찾기", Icons.Default.Search)
    object Storage : BottomNavItem(Route.Storage, "보관함", Icons.Default.Person)
}

@Composable
fun BottomNavigation(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
) {
    val navItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Purchase,
        BottomNavItem.Webtoon,
        BottomNavItem.Search,
        BottomNavItem.Storage
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