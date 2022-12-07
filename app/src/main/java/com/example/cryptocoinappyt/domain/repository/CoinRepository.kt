package com.example.cryptocoinappyt.domain.repository

import com.example.cryptocoinappyt.data.remote.dto.CoinDetailDto
import com.example.cryptocoinappyt.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}