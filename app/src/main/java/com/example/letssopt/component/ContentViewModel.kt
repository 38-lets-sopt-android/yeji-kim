package com.example.letssopt.component

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.data.Content

class ContentViewModel : ViewModel() {
    val contents1 = listOf<Content>(
        Content("이 사랑 통역 되나요?", R.drawable.img_translation),
        Content("프로젝트 헤일메리", R.drawable.img_hailmary),
        Content("기묘한 이야기", R.drawable.img_starnger_things),
        Content("크라임씬", R.drawable.img_crime),
        Content("파묘", R.drawable.img_grave),
        Content("왕과 사는 남자", R.drawable.img_king)
    )

    val contents2 = listOf<Content>(
        Content("왕과 사는 남자", R.drawable.img_king),
        Content("파묘", R.drawable.img_grave))

    val contents3 = listOf<Content>(
        Content("크라임씬", R.drawable.img_crime),
        Content("프로젝트 헤일메리", R.drawable.img_hailmary),
        Content("왕과 사는 남자", R.drawable.img_king)
    )
}