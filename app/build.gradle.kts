plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.resepmasakan"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.resepmasakan"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    dependencies {
        implementation("androidx.navigation:navigation-fragment-ktx:2.9.6")
        implementation("androidx.navigation:navigation-ui-ktx:2.9.6")
        implementation("androidx.fragment:fragment-ktx:1.7.0")
        implementation("androidx.cardview:cardview:1.0.0")
        implementation("androidx.recyclerview:recyclerview:1.3.2")
        implementation("com.google.android.material:material:1.12.0")
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
    }
}