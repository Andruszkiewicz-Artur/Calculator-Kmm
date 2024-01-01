package com.andruszkiewiczarturmobiledev.calculator_kmm.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.comp.MainPresentation
import moe.tlaster.precompose.lifecycle.PreComposeActivity

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainPresentation()
        }
    }
}
