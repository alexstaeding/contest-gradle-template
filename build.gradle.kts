@Suppress("DSL_SCOPE_VIOLATION") // fixed in Gradle 8.1
plugins {
    java
    alias(libs.plugins.kotlin.jvm)
    application
}

application {
    // for kotlin
    // mainClass.set("contest.KotlinMainKt")
    // for java
    mainClass.set("contest.JavaMain")
}

repositories {
    mavenCentral()
}

dependencies {
}

kotlin {
    jvmToolchain(17)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    val runDir = file("run")
    withType<JavaExec> {
        doFirst {
            runDir.mkdirs()
        }
        workingDir = runDir
    }
    test {
        useJUnitPlatform()
        workingDir = runDir
    }
}
