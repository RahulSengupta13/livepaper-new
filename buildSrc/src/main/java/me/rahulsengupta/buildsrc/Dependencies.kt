package me.rahulsengupta.buildsrc;

object AppMetaData {
    const val id = "me.rahulsengupta.architecture_sample"
    const val compileSdkVersion = 29
    const val targetSdkVersion = 29
    const val minSdkVersion = 24
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildToolsVersion = "29.0.2"
}

object Versions {
    // Application
    const val kotlin = "1.3.41"
    const val gradle = "3.5.0"

    // Core
    const val androidXCore = "1.1.0"
    const val androidXAppCompact = "1.1.0"

    // UI
    const val constraintLayout = "1.1.3"
    const val googleAndroidMaterial = "1.0.0"

    // Test
    const val jUnit = "4.12"
    const val testRunner = "1.2.0"
    const val testEspresso = "3.2.0"
}

object Libraries {
    // Core
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidXAppCompact}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidXCore}"

    // UI
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val googleAndroidMaterial =
        "com.google.android.material:material:${Versions.googleAndroidMaterial}"

    // Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testEspresso = "androidx.test.espresso:espresso-core:${Versions.testEspresso}"
}
