package com.example.letssopt.presentation.purchase

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.data.repository.PurchaseRepository
import com.example.letssopt.data.repository.impl.PurchaseRepositoryImpl

class PurchaseViewModel : ViewModel() {
    private val purchaseRepository: PurchaseRepository = PurchaseRepositoryImpl()

    var purchaseTitle by mutableStateOf(purchaseRepository.getPurchaseTitle())
        private set
}