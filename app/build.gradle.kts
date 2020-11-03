plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.buildToolsVersion)

    defaultConfig {
        applicationId = "com.carrion.edward.androidkotlinretrofitcoroutine"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        buildTypes.all {
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "API_KEY", "\"fa1246d69b21400c5406a9a931c26b80\"")
            buildConfigField("String", "MOVIES", "\"movie/popular\"")
            buildConfigField("String", "BASE_URL_IMAGE", "\"https://image.tmdb.org/t/p/w185/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.coreKtx)
    implementation(Libraries.appCompat)
    implementation(Libraries.activityKtx)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)

    implementation(Libraries.hilt)
    kapt(Libraries.hiltCompiler)

    implementation(Libraries.hiltLifecycleViewModel)
    kapt(Libraries.hiltLifecycleCompiler)

    implementation(Libraries.coil)

    implementation(Libraries.gson)
    implementation(Libraries.retrofit)
    implementation(Libraries.converterGson)
    implementation(Libraries.loggingInterceptor)

    implementation(Libraries.lifecycleExtensions)
    implementation(Libraries.lifecycleLiveDataKtx)
    implementation(Libraries.lifecycleViewModelKtx)
    kapt(Libraries.lifecycleCompiler)

    testImplementation(TestLibraries.junit)
    androidTestImplementation(TestLibraries.androidxJunit)
    androidTestImplementation(TestLibraries.androidxEspressoCore)
}

kapt {
    correctErrorTypes = true
}