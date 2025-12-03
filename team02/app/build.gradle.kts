plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.parkingspotmanager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.parkingspotmanager"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation (libs.gson)
    implementation (libs.core)
    implementation (libs.javase)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (libs.gson.javatime.serialisers)//MIN TO PEIRAXEI KANENAS
    implementation (libs.javafx.graphics)
    implementation (libs.core.v340)
    implementation (libs.zxing.android.embedded)
    testImplementation (libs.robolectric.v410)

}