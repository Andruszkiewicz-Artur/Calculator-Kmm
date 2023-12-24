package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.screens.main

sealed class MainEvent {
    data class AddNumber(val value: String): MainEvent()
    data class AddOption(val value: String): MainEvent()
}
