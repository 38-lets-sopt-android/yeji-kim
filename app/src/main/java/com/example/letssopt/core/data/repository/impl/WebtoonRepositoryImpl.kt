package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.core.data.repository.WebtoonRepository

class WebtoonRepositoryImpl : WebtoonRepository {
    override fun getWebtoonTitle(): String {
        return "웹툰 화면"
    }
}