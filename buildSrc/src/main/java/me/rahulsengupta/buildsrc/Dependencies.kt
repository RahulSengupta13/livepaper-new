package me.rahulsengupta.buildsrc

object AppMetaData {
    const val id = "me.rahulsengupta.livepaper"
    const val compileSdkVersion = 29
    const val targetSdkVersion = 29
    const val minSdkVersion = 24
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildToolsVersion = "29.0.2"
}

object Versions {
    // Application
    const val kotlin = "1.3.50"
    const val gradle = "3.5.0"

    // Core
    const val androidXCore = "1.1.0"
    const val androidXAppCompact = "1.1.0"
    const val androidXAnnotation = "1.1.0"
    const val androidXTest = "1.0.0"
    const val androidJUnit = "1.1.2-alpha02"
    const val lifecycle = "2.2.0-alpha04"
    const val multidex = "1.0.3"
    const val koin = "2.0.1"
    const val coroutines = "1.3.1"

    // UI
    const val constraintLayout = "2.0.0-beta2"
    const val googleAndroidMaterial = "1.1.0-alpha10"

    // Room
    const val room = "2.2.0-rc01"

    // Network
    const val okHttp = "3.12.0"
    const val retrofit = "2.6.0"
    const val gson = "2.8.5"
    const val coroutineCallAdapter = "0.9.2"

    // Test
    const val jUnit = "4.12"
    const val testRunner = "1.2.0"
    const val testEspresso = "3.2.0"

    // Logging
    const val timber = "4.7.1"

    // Navigation
    const val navigation = "2.2.0-alpha02"

    const val jacoco = "0.8.4"

    const val swipeRefreshLayout = "1.0.0"
}

object Libraries {
    // Core
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidXAppCompact}"
    const val androidxAnnotation = "androidx.annotation:annotation:${Versions.androidXAnnotation}"
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidXCore}"
    const val androidxTest = "androidx.test:core:${Versions.androidXTest}"
    const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"

    const val multidex = "com.android.support:multidex:${Versions.multidex}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"


    const val koinXcore = "org.koin:koin-core:${Versions.koin}"
    const val koinXscope = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinXviewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koinTest = "org.koin:koin-test:${Versions.koin}"

    // UI
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val googleAndroidMaterial = "com.google.android.material:material:${Versions.googleAndroidMaterial}"

    // Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testEspresso = "androidx.test.espresso:espresso-core:${Versions.testEspresso}"

    //Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKTX = "androidx.room:room-ktx:${Versions.room}"

    // Network
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okhttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val coroutineCallAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutineCallAdapter}"

    //Logging
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Navigation
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"

    const val jacoco = "org.jacoco:org.jacoco.core:${Versions.jacoco}"
}

object Modules {
    const val app = ":app"
    const val abstractor = ":abstractor"
    const val domain = ":domain"
    const val network = ":network"
    const val persistence = ":persistence"
    const val shared = ":shared"

    // Feature Modules
    const val home = ":home"
    const val settings = ":settings"
}

object GradleTemplates {
    const val androidLibrary = "template-android-library.gradle"
    const val featureLibrary = "template-feature-module.gradle"
    const val kotlinLibrary = "template-kotlin-library.gradle"
    const val jacoco = "jacoco.gradle"
}
