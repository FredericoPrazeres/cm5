package com.example.myapplication.navigation

sealed class Screens(val route:String){


    object Roll : Screens("roll_screen")
    object MainActivity : Screens("main_activity/{result}")
    object DiceResult : Screens("result_screen/{result}")
    object Result1 : Screens("result1")
    object Result2 : Screens("result2")
    object Result3 : Screens("result3")
    object Result4 : Screens("result4")
    object Result5 : Screens("result5")
    object Result6 : Screens("result6")

}
