const val kotlinVersion = "1.3.72"
const val hiltVersion = "2.28-alpha"

object Build {
    object Versions {
        const val androidGradlePlugin = "4.0.0"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val hilt = "dagger.hilt.android.plugin"
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
        const val activityKtx = "1.1.0"
        const val material = "1.2.1"
        const val constraintLayout = "2.0.2"

        const val coil = "1.0.0"

        const val gson = "2.8.6"
        const val retrofit = "2.9.0"
        const val converterGson = "2.9.0"
        const val loggingInterceptor = "4.9.0"

        const val lifecycleExtensions = "2.2.0"
        const val lifecycleLivedataKtx = "2.2.0"
        const val lifecycleViewModelKtx = "2.2.0"
        const val lifecycleCompiler = "2.2.0"

        const val hiltLifecycle = "1.0.0-alpha01"

        const val paging3 = "3.0.0-alpha11"
        const val room = "2.3.0-alpha04"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val coreKtx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLifecycle}"
    const val hiltLifecycleCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltLifecycle}"

    const val hilt = "com.google.dagger:hilt-android:${hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${hiltVersion}"

    const val coil = "io.coil-kt:coil:${Versions.coil}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedataKtx}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModelKtx}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleCompiler}"

    const val paging3 = "androidx.paging:paging-runtime:${Versions.paging3}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
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