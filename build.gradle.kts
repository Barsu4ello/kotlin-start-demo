plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.13.4")
    testImplementation("org.mockito:mockito-core:5.19.0")
    testImplementation("org.assertj:assertj-core:3.27.4")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
//    testImplementation("org.mockito:mockito-junit-jupiter:5.19.0")
    implementation("org.json:json:20250517")
//    implementation("com.fasterxml.jackson.core:jackson-databind:2.20.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.20.0")
//    implementation("com.google.code.gson:gson:2.13.1") // для работы с json от гугла (есть в retrofit через converter)
//    implementation("org.simpleframework:simple-xml:2.7.1") // устарела (есть в retrofit через converter)
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    implementation("com.squareup.retrofit2:converter-simplexml:3.0.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}