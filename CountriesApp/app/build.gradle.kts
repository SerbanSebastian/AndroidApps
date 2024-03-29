plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlinx-serialization")
}

android {
  namespace = "com.example.countriesapplication"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.example.countriesapplication"
    minSdk = 28
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    compose = true
    viewBinding = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  implementation("androidx.navigation:navigation-fragment:2.7.6")
  implementation("androidx.navigation:navigation-ui:2.7.6")
  implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
  implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
  implementation("androidx.navigation:navigation-dynamic-features-fragment:2.7.6")
  implementation("androidx.navigation:navigation-compose:2.7.6")
  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.appcompat:appcompat:1.6.1")
  implementation("com.google.android.material:material:1.11.0")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation("androidx.recyclerview:recyclerview:1.3.2")
  implementation("androidx.cardview:cardview:1.0.0")
  implementation("com.squareup.okhttp3:okhttp:4.7.2")
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
  implementation("com.github.bumptech.glide:glide:4.15.1")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.navigation:navigation-testing:2.7.6")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}