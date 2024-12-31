plugins {
    application
}

dependencies {
    implementation(files("lib/stub.jar"))
    implementation(libs.openrs2.deob.annotations)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

application {
    mainClass = "client"
    applicationDefaultJvmArgs = listOf("-Xmx256m", "-Dsun.java2d.noddraw=true")
}

tasks.run.configure {
    args = listOf("1", "1000", "local", "live", "english", "game0")
}
