package com.example.myapplication

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.Screens
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.math.abs
import kotlin.math.roundToInt

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
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }

        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString(),
            modifier = Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }

                }
        )
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

    val sensorManager = LocalContext.current.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val accelerometerSensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    val sensorEventListener = remember {
        object : SensorEventListener {

            var lastUpdate: Long = 0
            var lastX = 0f
            var lastY = 0f
            var lastZ = 0f
            val shakeThreshold = 800 // Adjust the threshold as needed


            override fun onSensorChanged(event: SensorEvent?) {
                event?.let {
                    if (it.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                        val currentTime = System.currentTimeMillis()
                        val timeDifference = currentTime - lastUpdate

                        if (timeDifference > 100) {
                            val diffTime = currentTime - lastUpdate
                            lastUpdate = currentTime
                            val speed = abs(event.values[0] + event.values[1] + event.values[2] - lastX - lastY - lastZ) / diffTime * 10000

                            if (speed > shakeThreshold) {
                                val newValue = (1..6).random()
                                result = newValue
                            }
                            lastX = event.values[0]
                            lastY = event.values[1]
                            lastZ = event.values[2]
                        }
                    }
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                // Do something if the accuracy of the sensor changes
            }
        }
    }

    LaunchedEffect(Unit) {
        sensorManager.registerListener(
            sensorEventListener,
            accelerometerSensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

}











