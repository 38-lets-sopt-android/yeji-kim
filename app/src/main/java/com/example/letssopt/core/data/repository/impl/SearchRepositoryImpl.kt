package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.core.data.repository.SearchRepository

class SearchRepositoryImpl : SearchRepository {
    override fun getSearchTitle(): String {
        return "찾기 화면"
    }
}