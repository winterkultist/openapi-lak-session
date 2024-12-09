import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    java
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
    id("org.openapi.generator") version "7.10.0"
    id("springdoc.openapi.starter.common") version "2.6.0"
}

group = "at.twinformatics"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

val openApiGenerateParams =
    mapOf(
        "library" to "spring-boot",
        "interfaceOnly" to "true",
        "useTags" to "true",
        "useSpringBoot3" to "true",
        "exceptionHandler" to "false",
        "openApiNullable" to "false",
        "skipDefaultInterface" to "true",
        "requestMappingMode" to "api_interface"
    )

tasks.register<GenerateTask>("openApiGenerateSpaceport") {
    generatorName.set("spring")
    inputSpec.set("$projectDir/src/main/resources/openapi/spaceport.0.0.1.yaml")
    outputDir.set("$projectDir/build/generated/openapi")
    packageName.set("at.twinformatics.openapilaksession")
    apiPackage.set("at.twinformatics.openapilaksession.web.api")
    modelPackage.set("at.twinformatics.openapilaksession.web.model")
    removeOperationIdPrefix.set(true)
    configOptions.set(openApiGenerateParams.toMap()) // clone it as to not touch default setup
    configOptions.put("generateApi", "false")
}

tasks.compileJava {
    dependsOn("openApiGenerateSpaceport")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets {
    main {
        java {
            srcDir(tasks.named("openApiGenerateSpaceport"))
        }
    }
}
