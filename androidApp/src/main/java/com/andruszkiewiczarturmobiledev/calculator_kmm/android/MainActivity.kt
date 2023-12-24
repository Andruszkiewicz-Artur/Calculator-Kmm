package com.andruszkiewiczarturmobiledev.calculator_kmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.screens.main.comp.MainPresentation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainPresentation()
            }
        }
    }
}
