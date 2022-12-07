package com.example.cryptocoinappyt.domain.repository

import com.example.cryptocoinappyt.data.remote.CoinPaprikaApi
import com.example.cryptocoinappyt.data.remote.dto.CoinDetailDto
import com.example.cryptocoinappyt.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}