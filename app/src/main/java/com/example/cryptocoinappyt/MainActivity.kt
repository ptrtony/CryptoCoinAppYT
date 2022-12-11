package com.example.cryptocoinappyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptocoinappyt.common.Constants
import com.example.cryptocoinappyt.presentation.Screen
import com.example.cryptocoinappyt.presentation.coin_detail.components.CoinDetailScreen
import com.example.cryptocoinappyt.presentation.coin_list.components.CoinListScreen
import com.example.cryptocoinappyt.presentation.theme.ui.CryptoCoinAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCoinAppYTTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/" + Constants.PARAMS_COIN_ID,
                            arguments = listOf(
                                navArgument(
                                    name = Constants.PARAMS_COIN_ID
                                ) {
                                    defaultValue = "-1"
                                    type = NavType.StringType
                                    nullable = false
                                }
                            )
                        ) { entity ->
                            val coinId = entity.arguments?.getString(Constants.PARAMS_COIN_ID)
                            savedInstanceState?.putString(Constants.PARAMS_COIN_ID, coinId)
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}