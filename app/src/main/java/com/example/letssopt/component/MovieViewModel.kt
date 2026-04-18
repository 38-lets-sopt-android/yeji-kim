package com.example.letssopt.component

import androidx.lifecycle.ViewModel
import com.example.letssopt.R

class MovieViewModel : ViewModel() {
    val movies = listOf<Movie>(
        Movie("이 사랑 통역 되나요?", R.drawable.translation),
        Movie("프로젝트 헤일메리", R.drawable.hailmary),
        Movie("기묘한 이야기", R.drawable.starnger_things),
        Movie("크라임씬", R.drawable.crime),
        Movie("파묘", R.drawable.grave),
        Movie("왕과 사는 남자", R.drawable.king)
    )

    val movies2 = listOf<Movie>(
        Movie("왕과 사는 남자", R.drawable.king),
        Movie("파묘", R.drawable.grave))
}