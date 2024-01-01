package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.di

import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.MainViewModel
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(getSharedModules())
    }

fun KoinApplication.Companion.start(): KoinApplication = initKoin { }

val Koin.mainViewModel: MainViewModel
    get() = get()