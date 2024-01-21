package com.example.punkapibeer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.punkapibeer.models.BeerModel
import com.example.punkapibeer.utils.Constantes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Definimos los componentes que vamos a usar en la vista
fun MainTopBar(
    title: String
){
    TopAppBar(title = {
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold
        )
    },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
           containerColor = Color(Constantes.COLOR_A)
        )
    )
}
//Antiguo CardView
@Composable
fun CardBeer(
    beer: BeerModel?,
    //beer: List<BeerModel>?,
    onCllick: () -> Unit
){
   Card(
       shape = RoundedCornerShape(4.dp),
       modifier = Modifier
           .padding(8.dp)
           .shadow(40.dp)
           .clickable { onCllick() }
   ){
       Column {
           if (beer != null) {
               StartImage(picture = beer.image)
           }
       }
   }
}

@Composable
fun StartImage(picture: String){
    val imagen = rememberAsyncImagePainter(model = picture)

    Image(
        painter = imagen,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}