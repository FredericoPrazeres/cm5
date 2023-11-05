package com.example.myapplication.results

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.navigation.Screens

@Composable
fun Result4(
    navController: NavController,
    modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { navController.navigate(Screens.Roll.route) },
            modifier= Modifier.padding(4.dp)
        ) {
            Text(text = (stringResource(R.string.back)), fontSize = 24.sp)
        }

        Button(
            onClick = { navController.navigate(Screens.Result1.route) },
            modifier= Modifier.padding(8.dp)
        ) {
            Text(text = "Screen1", fontSize = 36.sp)
        }

        Button(
            onClick = { navController.navigate(Screens.Result2.route) },
            modifier= Modifier.padding(8.dp)
        ) {
            Text(text = "Screen2", fontSize = 36.sp)
        }

        Button(
            onClick = { navController.navigate(Screens.Result3.route) },
            modifier= Modifier.padding(8.dp)
        ) {
            Text(text = "Screen3", fontSize = 36.sp)
        }

        Button(
            onClick = { navController.navigate(Screens.Result4.route) },
            modifier= Modifier.padding(8.dp)
        ) {
            Text(text = "Screen4", fontSize = 36.sp)
        }

        Button(
            onClick = { navController.navigate(Screens.Result5.route) },
            modifier= Modifier.padding(8.dp)
        ) {
            Text(text = "Screen5", fontSize = 36.sp)
        }

        Button(
            onClick = { navController.navigate(Screens.Result6.route) },
            modifier= Modifier.padding(8.dp)
        ) {
            Text(text = "Screen6", fontSize = 36.sp)
        }

    }


}