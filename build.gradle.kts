plugins {
    java
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
}

//project("sub-project-1") {
//    apply(plugin = "java")
//}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
}

allprojects {
    group = "com.example"
    version = "0.0.1-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_17
    repositories {
        mavenCentral()
    }
    dependencies {
        implementation("jakarta.websocket:jakarta.websocket-api:2.1.1")
        implementation("org.springframework.boot:spring-boot-starter-web")
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    task("hello").doLast {
        println("I'm ${project.name}")
    }
}
