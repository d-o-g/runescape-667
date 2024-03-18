plugins {
    application
}

dependencies {
    implementation(project(":runescape"))
    implementation(libs.bouncycastle.bcpkix)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

application {
    mainClass.set("Client")
}
