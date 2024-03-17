plugins {
    application
}

dependencies {
    implementation(files("lib/stub.jar"))
    implementation(project(":openrs2-deob-annotations") /* libs.openrs2.deob.annotations */)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

application {
    mainClass = "client"
}
