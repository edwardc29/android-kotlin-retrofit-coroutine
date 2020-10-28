const val kotlinVersion = "1.3.72"

object Build {
    object Versions {
        const val androidGradlePlugin = "4.0.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
    const val buildToolsVersion = "29.0.3"
}

object Libraries {
    private object Versions {
        const val ktx = "1.3.0"
        const val appCompat = "1.2.0"
        const val material = "1.2.1"
        const val constraintLayout = "2.0.2"

        const val coil = "1.0.0"

        const val gson = "2.8.0"
        const val retrofit = "1.1.0"
        const val converterGson = "2.6.0"
        const val loggingInterceptor = "4.9.0"

        const val lifecycleExtensions = "2.2.0"
        const val lifecycleLivedataKtx = "2.2.0"
        const val lifecycleViewModelKtx = "2.2.0"
        const val lifecycleCompiler = "2.2.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val coreKtx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedataKtx}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleCompiler}"
}

object TestLibraries {
    private object Versions {
        const val junit = "4.13.1"
        const val androidxJunit = "1.1.2"
        const val androidxEspressoCore = "3.3.0"
    }

    const val junit = "junit:junit:${Versions.junit}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val androidxEspressoCore =
        "androidx.test.espresso:espresso-core:${Versions.androidxEspressoCore}"
}