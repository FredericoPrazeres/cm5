package com.example.myapplication.results

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Result5(
    modifier: Modifier = Modifier,
    navController: NavController,
    resultShow: Int = 5,
    ) {

    var result by remember { mutableStateOf(resultShow) }
    var newDiceValue by remember { mutableStateOf(result.toString()) }
    var errorMessage by remember { mutableStateOf("") }


    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }


    Column(
        modifier = modifier.fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(imageResource), contentDescription = result.toString())


        Text("New Dice Value:")
        Spacer(modifier = Modifier.width(8.dp))
        TextField(
            value = newDiceValue,
            onValueChange = {
                newDiceValue = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.width(100.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {
                val newValue = newDiceValue.toIntOrNull()

                if (newValue in 1..6) {
                    result = newValue!!
                    errorMessage = ""
                } else {
                    errorMessage = "Value must be between 1 and 6"
                }


            }
        ) {
            Text("Change")
        }

        Text(text = errorMessage, color = Color.Red)

        Button(
            onClick = { navController.navigate(Screens.Roll.route) },
        ) {
            Text(text = (stringResource(R.string.back)), fontSize = 24.sp)
        }

    }


}