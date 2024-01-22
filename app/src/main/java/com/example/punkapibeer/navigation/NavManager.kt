package com.example.punkapibeer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.punkapibeer.viewmodels.BeersViewModel
import com.example.punkapibeer.views.DetailView
import com.example.punkapibeer.views.InicioView

//Objeto composable que se va a ancargar de orquestar la navegacion
@Composable
fun NavManager(
    viewModel: BeersViewModel
) { //Recibe como parametro viewmodels

    //Estado para el map controller a propagar entre las pantallas
    val navController = rememberNavController()

    NavHost( //Va a conocer las pantallas y como navegar entre ellas
        navController = navController,
        startDestination = AppScreens.BeersScreen.route
    ) {
        composable(AppScreens.BeersScreen.route) {
            //Invocamos el archivo de la vista
            InicioView(navController, viewModel)
        }

        composable(AppScreens.BeerScreen.route) {
            DetailView(navController, viewModel)
        }
    }
}


