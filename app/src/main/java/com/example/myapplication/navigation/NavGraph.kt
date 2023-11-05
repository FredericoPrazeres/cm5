package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.BusinessCallingCardExample
import com.example.myapplication.diceroller.DiceResult
import com.example.myapplication.DiceWithButtonAndImage
import com.example.myapplication.results.Result1
import com.example.myapplication.results.Result2
import com.example.myapplication.results.Result3
import com.example.myapplication.results.Result4
import com.example.myapplication.results.Result5
import com.example.myapplication.results.Result6

@Composable
fun NavGraph (navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Roll.route
    )
    {
        composable(route = Screens.Roll.route) {
            DiceWithButtonAndImage(navController = navController)
        }

        composable(route = Screens.MainActivity.route + "?result={result}") {navBackStack ->
            val resultShow: Int = navBackStack.arguments?.getString("result")?.toIntOrNull() ?: 1
            DiceWithButtonAndImage(navController = navController, resultShow = resultShow)
        }


        composable(route = Screens.DiceResult.route + "?result={result}") { navBackStack ->
            val resultShow: Int = navBackStack.arguments?.getString("result")?.toIntOrNull() ?: 1
            DiceResult(navController = navController, resultShow = resultShow)
        }

        composable(route = Screens.Result1.route) {

            Result1(navController = navController)
        }

        composable(route = Screens.Result2.route) {

            Result2(navController = navController)
        }

        composable(route = Screens.Result3.route) {

            Result3(navController = navController)
        }

        composable(route = Screens.Result4.route) {

            Result4(navController = navController)
        }

        composable(route = Screens.Result5.route) {

            Result5(navController = navController)
        }

        composable(route = Screens.Result6.route) {

            Result6(navController = navController)
        }

    }
}

