package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.core.data.repository.PurchaseRepository

class PurchaseRepositoryImpl : PurchaseRepository {
    override fun getPurchaseTitle(): String {
        return "개별구매 화면"
    }
}