plugins {
    application
}

dependencies {
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
    mainClass = "loader"
}
