plugins {
    application
}

dependencies {
    implementation(project(":openrs2-deob-annotations") /* libs.openrs2.deob.annotations */)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

application {
    mainClass = "loader"
}
