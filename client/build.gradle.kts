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
    mainClass = "Client"
    applicationDefaultJvmArgs = listOf("-Xmx256m", "-Dsun.java2d.noddraw=true")
}
