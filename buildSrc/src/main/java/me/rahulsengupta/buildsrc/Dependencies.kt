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
    const val androidXTest = "1.0.0"
    const val lifecycle = "2.2.0-alpha02"
    const val multidex = "1.0.3"
    const val koin = "2.0.1"
    const val coroutines = "1.3.0-M2"

    // UI
    const val constraintLayout = "1.1.3"
    const val googleAndroidMaterial = "1.0.0"

    // Network
    const val okHttp = "3.12.0"
    const val retrofit = "2.6.0"
    const val gson = "2.8.5"

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
    const val androidxTest = "androidx.test:core:${Versions.androidXTest}"

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
    const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val googleAndroidMaterial =
            "com.google.android.material:material:${Versions.googleAndroidMaterial}"

    // Test
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testEspresso = "androidx.test.espresso:espresso-core:${Versions.testEspresso}"

    // Network
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okhttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object Modules {
    const val app = ":app"
    const val abstractor = ":abstractor"
    const val domain = ":domain"
    const val network = ":network"
}

object GradleTemplates {
    const val androidLibrary = "template-android-lib.gradle"
}
