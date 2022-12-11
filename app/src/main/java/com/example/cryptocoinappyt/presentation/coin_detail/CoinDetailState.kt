package com.example.cryptocoinappyt.presentation.coin_detail

import com.example.cryptocoinappyt.domain.model.CoinDetail

data class CoinDetailState(
    val coin: CoinDetail ?= null,
    val error: String = "",
    val isLoading: Boolean = false
)