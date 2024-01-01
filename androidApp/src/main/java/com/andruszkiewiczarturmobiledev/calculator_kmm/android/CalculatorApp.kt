package com.andruszkiewiczarturmobiledev.calculator_kmm.android

import android.app.Application
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.di.initKoin

class CalculatorApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {

        }

    }

}