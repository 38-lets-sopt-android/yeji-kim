package com.example.letssopt.data.repository.impl

import com.example.letssopt.data.repository.WebtoonRepository

class WebtoonRepositoryImpl : WebtoonRepository {
    override fun getWebtoonTitle(): String {
        return "웹툰 화면"
    }
}