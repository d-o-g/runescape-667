plugins {
    application
}

dependencies {
    implementation(project(":runescape"))
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

application {
    mainClass.set("Client")
}
