plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "jakarta.xml.bind", name = "jakarta.xml.bind-api", version = "4.0.1")
    implementation(group = "org.glassfish.jaxb", name = "jaxb-runtime", version = "4.0.4")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}