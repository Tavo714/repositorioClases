plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.pixelpulse.app_final"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pixelpulse.app_final"
        minSdk = 24
        targetSdk = 35
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-firestore-ktx")

    // Material Design
    implementation("com.google.android.material:material:1.10.0")

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Circle ImageView
    implementation(libs.circleimageview)

    // AndroidX Core y RecyclerView
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Dependencias de pruebas
    testImplementation("junit:junit:4.13.2") // Pruebas unitarias locales
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // JUnit para pruebas instrumentadas
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Pruebas de UI
}

