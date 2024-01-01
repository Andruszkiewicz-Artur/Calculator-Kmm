package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main

data class MainState(
    val presentedValue: String = "0",
    val currentValue: String = "0",
    val values: MutableList<String> = mutableListOf()
)
