package com.example.letssopt.presentation.webtoon

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.data.repository.WebtoonRepository
import com.example.letssopt.data.repository.impl.WebtoonRepositoryImpl

class WebtoonViewModel : ViewModel() {
    private val webtoonRepository: WebtoonRepository = WebtoonRepositoryImpl()

    var webtoonTitle by mutableStateOf(webtoonRepository.getWebtoonTitle())
        private set
}