// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        //mavenCentral()
        google()
        jcenter()
    }

    dependencies {
        classpath(Build.androidGradlePlugin)
        classpath(Build.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        //mavenCentral()
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}