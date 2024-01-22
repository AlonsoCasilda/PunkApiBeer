package com.example.punkapibeer.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.punkapibeer.components.CardBeer
import com.example.punkapibeer.components.MainTopBar
import com.example.punkapibeer.utils.Constantes
import com.example.punkapibeer.viewmodels.BeersViewModel

@Composable
fun DetailView(
    navController: NavController,
    viewModel: BeersViewModel,
) {
    Scaffold(
        topBar = {
            //Hacemos referencia a componentes a usar en otro archivo para poder reutilizaro
            MainTopBar(title = "Beer Detail")
        }
    ) {
        DetailViewContent(
            navController = navController,
            viewModel = viewModel,
            pad = it,
        )
    }
}


@Composable
fun DetailViewContent(
    navController: NavController,
    viewModel: BeersViewModel,
    pad: PaddingValues,
) {

    val beerState by remember { mutableStateOf(viewModel.beerState) }

    Column(
        modifier = Modifier
            .padding(pad)
    ) {
        Column(
            modifier = Modifier
                .background(Color(Constantes.COLOR_B))
        ) {
            CardBeer(beer = beerState) {}
            Text(
                text = beerState.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 12.dp)
            )
            Text(
                text = beerState.description,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 12.dp)
            )
            Text(
                text = "Graduacion: " + beerState.abv,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Blue,
                modifier = Modifier
                    .padding(start = 12.dp)
            )
        }
    }
}
