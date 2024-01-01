package com.andruszkiewiczarturmobiledev.calculator_kmm

import androidx.compose.ui.window.ComposeUIViewController
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.comp.MainPresentation
import moe.tlaster.precompose.PreComposeApplication

fun MainViewController() = ComposeUIViewController { MainPresentation() }