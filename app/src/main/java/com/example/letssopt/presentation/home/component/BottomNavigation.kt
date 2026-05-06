package com.example.letssopt.presentation.home.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.example.letssopt.presentation.main.component.MainTab

@Composable
fun BottomNavigation(
    isshowBottomBar: Boolean,
    currentTab: MainTab,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
) {
    val navItems = listOf(
        MainTab.HOME,
        MainTab.PURCHASE,
        MainTab.WEBTOON,
        MainTab.SEARCH,
        MainTab.STORAGE
    )

    NavigationBar(containerColor = Color(0xFF141414)) {
        navItems.forEachIndexed { int, item ->
            selectedTabIndex == int

            NavigationBarItem(
                selected = selectedTabIndex == int,
                onClick = { onTabSelected(int) },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            id = if (selectedTabIndex == int) item.selectedIconRes else item.unselectedIconRes
                        ),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.titleRes),
                        color = if (selectedTabIndex == int) Color.White else Color.Gray
                    )
                }
            )
        }
    }
}