package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.screens.main

data class MainState(
    val presentedValue: String = "0",
    val currentValue: String = "0",
    val values: MutableList<String> = mutableListOf()
)
