package com.andruszkiewiczarturmobiledev.calculator_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform