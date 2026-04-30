package com.example.letssopt.data.repository.impl

import com.example.letssopt.data.repository.PurchaseRepository

class PurchaseRepositoryImpl : PurchaseRepository {
    override fun getPurchaseTitle(): String {
        return "개별구매 화면"
    }
}