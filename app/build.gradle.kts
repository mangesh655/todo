plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.google.devtools.ksp)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.mangesh.movieloading"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.mangesh.movieloading"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
            // Use JVM_1_8, JVM_11, JVM_17, etc., depending on your project
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }}

    dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.room.ktx)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)

        //hilt
        implementation(libs.hilt.android)
        ksp(libs.hilt.android.compiler)

        //paging
        implementation(libs.paging.runtime)

        //coroutines
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)

        //retrofit
        implementation(libs.retrofit2)
        implementation(libs.retrofit2.gson.converter)

        //okhttp
        implementation(libs.okhttp3)
        implementation(libs.okhttp3.logging.interceptor)

        //gson
        implementation(libs.gson)

        //room database
        implementation(libs.androidx.room.ktx)
        implementation(libs.room.runtime)
        ksp(libs.room.compiler)

        //compose
        implementation(libs.compose.ui)
        implementation(libs.compose.activity)
        implementation(libs.compose.runtime)
        implementation(libs.compose.material)
        implementation(libs.compose.tooling.preview)
        implementation(libs.hilt.navigation.compose)
    }