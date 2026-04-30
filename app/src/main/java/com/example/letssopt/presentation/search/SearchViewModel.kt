package com.example.letssopt.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.data.repository.SearchRepository
import com.example.letssopt.data.repository.impl.SearchRepositoryImpl

class SearchViewModel : ViewModel() {
    private val searchRepository: SearchRepository = SearchRepositoryImpl()

    var searchTitle by mutableStateOf(searchRepository.getSearchTitle())
        private set
}