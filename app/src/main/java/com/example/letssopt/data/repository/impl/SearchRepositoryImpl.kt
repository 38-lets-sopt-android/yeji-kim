package com.example.letssopt.data.repository.impl

import com.example.letssopt.data.repository.SearchRepository

class SearchRepositoryImpl : SearchRepository {
    override fun getSearchTitle(): String {
        return "찾기 화면"
    }
}