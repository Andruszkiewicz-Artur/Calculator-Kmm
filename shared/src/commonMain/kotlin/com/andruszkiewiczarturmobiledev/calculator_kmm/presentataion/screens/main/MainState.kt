package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.screens.main

data class MainState(
    val currentValue: String = "0",
    val values: MutableList<String> = mutableListOf(),
    val isClearClickable: Boolean = false,
    val isPlusMinusClickable: Boolean = false,
    val isEqualClickable: Boolean = false,
    val isZeroClickable: Boolean = false,
    val isCharClickable: Boolean = false,
    val isDoteClickable: Boolean = false
)
