package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}


@Composable
fun DiceWithButtonAndImage(
    modifier: Modifier = Modifier,
    navController: NavController,
    resultShow: Int = 1
    ) {

    var result by remember { mutableStateOf(resultShow) }
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
        Button(onClick = { result = (1..6).random() },
            modifier = Modifier.padding(8.dp)) {
            Text(stringResource(R.string.roll), fontSize = 20.sp)
        }
        Button(
            onClick = {
                navController.navigate(
                    Screens.DiceResult.route.replace(
                        oldValue = "{result}",
                        newValue = result.toString()
                    )
                )
                      }
            ,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = stringResource(R.string.result_screen), fontSize = 24.sp)
        }
    }



}











