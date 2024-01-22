package com.example.punkapibeer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.punkapibeer.navigation.NavManager
import com.example.punkapibeer.ui.theme.PunkApiBeerTheme
import com.example.punkapibeer.viewmodels.BeersViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val beersViewModel: BeersViewModel by viewModels()

        setContent {
            PunkApiBeerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavManager(
                        viewModel = beersViewModel)
                }
            }
        }
    }
}