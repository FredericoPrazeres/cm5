package com.example.myapplication.results

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.BusinessCallingCardDemo
import com.example.myapplication.R
import com.example.myapplication.navigation.Screens

@Composable
fun Result1(navController: NavController){

    BusinessCallingCardDemo(navController = navController)

    Button(
        onClick = { navController.navigate(Screens.Roll.route)},
    ) {
        Text(text = (stringResource(R.string.back)), fontSize = 24.sp)
    }


}