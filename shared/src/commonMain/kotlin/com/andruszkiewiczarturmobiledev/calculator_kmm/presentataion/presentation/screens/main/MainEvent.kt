package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main

sealed class MainEvent {
    data class AddNumber(val value: String): MainEvent()
    data class AddOption(val value: String): MainEvent()
    data object AddDote: MainEvent()
    data object SetUpPlusMinus: MainEvent()
    data object RemoveLast: MainEvent()
    data object SetUpResult: MainEvent()
    data object ClickPercent: MainEvent()
    data object ClearMemoryResult: MainEvent()
    data object AddFromMemoryResult: MainEvent()
    data object SubtractFromMemoryResult: MainEvent()
    data object ShowFromMemoryResult: MainEvent()
}
