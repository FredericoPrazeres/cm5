package com.example.myapplication.diceroller

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.results.Result3
import com.example.myapplication.results.Result5
import com.example.myapplication.results.Result1
import com.example.myapplication.results.Result2
import com.example.myapplication.results.Result4
import com.example.myapplication.results.Result6


@Composable
fun DiceResult(
    modifier: Modifier = Modifier,
    navController: NavController,
    resultShow: Int = 1
    ) {

    val result by remember { mutableStateOf(resultShow) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (result) {
            1 -> Result1(navController = navController)
            2 -> Result2(navController = navController)
            3 -> Result3(navController = navController)
            4 -> Result4(navController = navController)
            5 -> Result5(navController = navController)
            else -> Result6(navController = navController)
        }



    }


}