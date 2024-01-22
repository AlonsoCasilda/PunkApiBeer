package com.example.punkapibeer.navigation

//Unificacion en una sola clase todas las pantallas de la app
sealed class AppScreens(val route: String) {
    object BeersScreen: AppScreens("inicio")
    object BeerScreen: AppScreens("beer")

}