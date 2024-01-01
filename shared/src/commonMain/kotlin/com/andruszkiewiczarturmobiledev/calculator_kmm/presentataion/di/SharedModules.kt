package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.MainViewModel

private val viewModelModule = module {
    singleOf(::MainViewModel)
}

private val sharedModules = listOf(
    viewModelModule
)

fun getSharedModules() = sharedModules