package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.R
import com.example.letssopt.core.data.Content
import com.example.letssopt.core.data.HomeDataSet
import com.example.letssopt.core.data.repository.HomeRepository

class HomeRepositoryImpl : HomeRepository {
    /*
    private var homeDataSet: HomeDataSet? = null

    override fun getHomeDataSet(): HomeDataSet {
        if (homeDataSet == null) {
            homeDataSet = createHomeDataSet()
        }
        return homeDataSet!!
    }
    */
    override fun getHomeDataSet(): HomeDataSet {
        return HomeDataSet(
            topSection = listOf(Content("크라임씬", R.drawable.img_crime), Content("프로젝트 헤일메리", R.drawable.img_hailmary), Content("왕과 사는 남자", R.drawable.img_king)),
            middleSection = listOf(Content("이 사랑 통역 되나요?", R.drawable.img_translation), Content("프로젝트 헤일메리", R.drawable.img_hailmary), Content("기묘한 이야기", R.drawable.img_starnger_things), Content("크라임씬", R.drawable.img_crime), Content("파묘", R.drawable.img_grave), Content("왕과 사는 남자", R.drawable.img_king)),
            bottomSection = listOf(Content("왕과 사는 남자", R.drawable.img_king), Content("파묘", R.drawable.img_grave))
        )
    }

    override suspend fun getTopImages(): List<Content> = listOf(
        Content("크라임씬", R.drawable.img_crime),
        Content("프로젝트 헤일메리", R.drawable.img_hailmary),
        Content("왕과 사는 남자", R.drawable.img_king)
    )

    override suspend fun getMiddleImages(): List<Content> = listOf(
        Content("이 사랑 통역 되나요?", R.drawable.img_translation),
        Content("프로젝트 헤일메리", R.drawable.img_hailmary),
        Content("기묘한 이야기", R.drawable.img_starnger_things),
        Content("크라임씬", R.drawable.img_crime),
        Content("파묘", R.drawable.img_grave),
        Content("왕과 사는 남자", R.drawable.img_king))

    override suspend fun getBottomImages(): List<Content> = listOf(
        Content("왕과 사는 남자", R.drawable.img_king),
        Content("파묘", R.drawable.img_grave))
}