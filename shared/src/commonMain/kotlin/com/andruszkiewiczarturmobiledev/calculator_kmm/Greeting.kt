package com.andruszkiewiczarturmobiledev.calculator_kmm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

@Composable
fun MainPresentation() {
    val viewModel = Greeting()

   Surface {
       Box(
           contentAlignment = Alignment.Center,
           modifier = Modifier
               .fillMaxSize()
       ) {
           Text(
               text = viewModel.greet(),
               style = MaterialTheme.typography.titleLarge
           )
       }
   }
}