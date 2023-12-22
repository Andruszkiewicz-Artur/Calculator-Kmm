rootProject.name = "Calculator_Kmm"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}

include(":androidApp")
include(":shared")