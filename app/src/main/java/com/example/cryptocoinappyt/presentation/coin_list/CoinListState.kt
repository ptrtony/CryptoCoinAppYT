package com.example.cryptocoinappyt.presentation.coin_list

import com.example.cryptocoinappyt.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
