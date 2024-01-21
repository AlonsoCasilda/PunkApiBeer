package com.example.punkapibeer.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.punkapibeer.models.BeerModel
import com.example.punkapibeer.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


//Servira como enlace a las peticiones de endPoint por medio de la interfaz y las vistas del usuario

class BeersViewModel: ViewModel() {

    //Creo estado a traves de flow
    private val _beers = MutableStateFlow<List<BeerModel>?>(null)

    //Val que consume nuestras listas que nos permitirá modificar la informacion de la lista de beer
    //dentro del viewModel y creamos una variabe que sera de solo lectura para la parte visual del usuario
    val beers = _beers.asStateFlow()

    //Cada vez que se crea llamaremos a init
    init{
        getNombre("")
    }

    //TODO: Meter el método que te pide nombre  y al clickar llamar a obtener beer

    fun getNombre(beerName: String){
        viewModelScope.launch {
            Log.d("BeerViewModel", "Beer sugerida por usuario: $beerName")
            obtenerBeer(beerName)

        }

    }
    //metodos de viewModel en nuestro caso solo un metodo
    private fun obtenerBeer(beerNameSearched: String){
        viewModelScope.launch(Dispatchers.IO){//Dispatches de entrada y salida
            withContext(Dispatchers.Main){
                val response = RetrofitClient.retrofit.obtenerBeerByName(beerNameSearched)
                //Asignamos el valor del response de lo que se obtiene en el cuerpo
                _beers.value = response.body()
            }
        }
    }

    }