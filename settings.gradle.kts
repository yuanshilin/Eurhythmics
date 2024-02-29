pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //central
        maven("https://maven.aliyun.com/repository/central" )
        //jcenter\public
        maven("https://maven.aliyun.com/repository/public" )
        //google
        maven ("https://maven.aliyun.com/repository/google")
        //gradle-plugin
        maven ("https://maven.aliyun.com/repository/gradle-plugin" )
        maven ("https://jitpack.io" )
        maven ("https://plugins.gradle.org/m2/")

    }
}

rootProject.name = "Eurhythmics"
include(":app")
