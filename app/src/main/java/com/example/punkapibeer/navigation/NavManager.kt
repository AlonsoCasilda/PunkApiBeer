package com.example.punkapibeer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.punkapibeer.viewmodels.BeersViewModel
import com.example.punkapibeer.views.InicioView

@Composable
fun NavManager(viewModel: BeersViewModel){ //Recibe como parametro el viewModel

    //estado para el map controller
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio" //identificador
    ){
        composable("inicio"){
            //Invocamos el archivo de la vista
            InicioView(navController, viewModel)
        }
        /*
        *Para tener varias vistas
        composable("inicio"){
            //Invocamos el archivo de la vista
            InicioView(navController, viewModel)
        }
        composable("inicio"){
            //Invocamos el archivo de la vista
            InicioView(navController, viewModel)
        }
        composable("inicio"){
            //Invocamos el archivo de la vista
            InicioView(navController, viewModel)
        }
         */
    }

}


