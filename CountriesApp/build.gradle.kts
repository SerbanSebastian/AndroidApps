// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
  }
  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-serialization:1.8.10")
  }
}

plugins {
  id ("com.android.application") version "8.1.3" apply false
  id ("com.android.library") version "8.1.3" apply false
  id ("org.jetbrains.kotlin.android") version "1.8.10" apply false
}