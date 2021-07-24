
plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")

}
var compose_version = "1.0.0-rc02"

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    implementation("androidx.activity:activity-compose:1.3.0-rc02")

    implementation("androidx.compose.ui:ui:${compose_version}")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:${compose_version}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:${compose_version}")
    // Material Design
    implementation("androidx.compose.material:material:${compose_version}")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:${compose_version}")
    implementation("androidx.compose.material:material-icons-extended:${compose_version}")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:${compose_version}")
    implementation("androidx.compose.runtime:runtime-rxjava2:${compose_version}")

    implementation("com.google.dagger:hilt-android:2.37")
    kapt("com.google.dagger:hilt-android-compiler:2.37")
}



android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "net.muhaimin.flickrapp.android"
        minSdkVersion(28)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }

    // Set both the Java and Kotlin compilers to target Java 8.

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    composeOptions {
        kotlinCompilerVersion = "1.5.10"
        kotlinCompilerExtensionVersion = compose_version
    }

}