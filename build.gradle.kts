import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.spring") version "2.0.0"

    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    id("idea")

    id("org.openapi.generator") version "7.6.0"
}

kotlin {
    jvmToolchain(21)

    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

group = "ru.golubtsov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:2.0.0")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

    runtimeOnly("com.h2database:h2:2.2.224")
}


openApiGenerate {
    // смотри доку https://openapi-generator.tech/docs/generators/kotlin-spring
    generatorName.set("kotlin-spring")

    inputSpec.set("$rootDir/src/main/resources/open-api/openapiexample.yaml")
    outputDir.set("$buildDir/generated/api")

    configOptions.set(
        mapOf(
            "apiPackage" to "ru.golubtsov.controller",
            "apiSuffix" to "OpenapiExample",
            "artifactId" to "worker-api",

            "basePackage" to "ru.golubtsov",
            "configPackage" to "ru.golubtsov.config",
            "groupId" to "ru.golubtsov",

            "interfaceOnly" to "true",
            "library" to "spring-boot",

            "modelMutable" to "true",
            "modelPackage" to "ru.golubtsov.controller.dto",

            "packageName" to "ru.golubtsov",
//            "requestMappingMode" to "api_interface",
            "serverPort" to "8080", // стандарт, но если забыть и не поставить, то сложно отловить

            "sourceFolder" to "src/main/kotlin",
            "title" to "OpenAPI Example",
            "useSpringBoot3" to "true",
            "useTags" to "true",
        )
    )
}

tasks.compileKotlin {
    dependsOn(tasks.openApiGenerate)
}

sourceSets {
    getByName("main") {
        kotlin {
            srcDir("$buildDir/generated/api/src/main/kotlin")
        }
    }
}
