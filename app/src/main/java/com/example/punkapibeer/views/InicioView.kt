package com.example.punkapibeer.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.punkapibeer.components.CardBeer
import com.example.punkapibeer.components.MainTopBar
import com.example.punkapibeer.models.BeerModel
import com.example.punkapibeer.navigation.AppScreens
import com.example.punkapibeer.utils.Constantes
import com.example.punkapibeer.viewmodels.BeersViewModel

@Composable
fun InicioView(
    navController: NavController,
    viewModel: BeersViewModel,
){
    Scaffold(
        topBar = {
            //Hacemos referencia a componentes a usar en otro archivo para poder reutilizaro
            MainTopBar(title = "PunkApi")
        }
    ) {
        InitViewContent(
            navController = navController,
            viewModel = viewModel,
            pad = it
        )
    }
}

@Composable
fun InitViewContent(
    navController: NavController,
    viewModel: BeersViewModel,
    pad: PaddingValues,
) {
    //hace referencia al estado de las beers que tenemos en el viewModel
    val beers by viewModel.beers.collectAsState()

    // Estado para almacenar el texto ingresado en el TextField
    var textValue by remember { mutableStateOf("") }

    LaunchedEffect(textValue) {
        viewModel.getNombre(textValue)
    }

    Column(
        modifier = Modifier
            .padding(pad)
    ) {
        // TextField personalizado con un fondo diferente y bordes personalizados
        OutlinedTextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Buscar cerveza por nombre") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Green, // Color del borde cuando está enfocado
                unfocusedBorderColor = Color.Gray, // Color del borde cuando no está enfocado
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        //LazyColum como reciclerView de modo antiguo de xml
        LazyColumn(
            modifier = Modifier
                .background(Color(Constantes.COLOR_B))
        ) {
            beers?.let { it ->
                items(it.size) {
                    CardBeer(beer = beers!![it]) { //iteramos de la lista beer
                        //Cuando se seleccione mandamos el nombre de la cerveza seleccionada
                        //Actualizo el beerState
                        viewModel.updateBeerState(
                            BeerModel(
                                name = beers!![it].name,
                                description = beers!![it].description,
                                image = beers!![it].image,
                                abv = beers!![it].abv,
                            )
                        )
                        navController.navigate(route = AppScreens.BeerScreen.route)

                    }
                    Text(
                        text = beers!![it].name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 12.dp)
                    )
                    Text(
                        text = beers!![it].description,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 12.dp)
                    )
                }
            }
        }
    }
}