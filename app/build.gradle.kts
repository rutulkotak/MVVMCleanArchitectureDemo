plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.rutulkotak.mvvmcleanarchidemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rutulkotak.mvvmcleanarchidemo"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String","BASE_URL", "\"https://api.themoviedb.org/3/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    // Lifecycle
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.viewmodel.savedstate)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.livedata.common)
    // Room
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    implementation(libs.androidx.junit.ktx)
    ksp(libs.room.compiler)
    // Coroutines
    implementation(libs.coroutines)
    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.okhttp3)
    // Glide
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)
    // Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
    // Test
    testImplementation(libs.junit.test)
    testImplementation(libs.arch.core.test)
    testImplementation(libs.coroutine.test)
    testImplementation(libs.google.truth)
    testImplementation(libs.androidx.junit)
    testImplementation(libs.robolectric)
    // Android Test
    androidTestImplementation(libs.junit.test)
    androidTestImplementation(libs.arch.core.test)
    androidTestImplementation(libs.coroutine.test)
    androidTestImplementation(libs.google.truth)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}