package com.example.letssopt.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.letssopt.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF141414),
            actionIconContentColor = Color.White
        ),
        title = { },
        actions = {
            Row(
                modifier = Modifier.padding(end = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_topbar_camera),
                    contentDescription = "카메라",
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_topbar_noti),
                    contentDescription = "알림",
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_topbar_user),
                    contentDescription = "사용자",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    )
}