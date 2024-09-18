/*
 * Copyright 2018 Duncan Casteleyn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KaptGenerateStubs
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    val kotlinVersion = "2.0.20"

    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    id("org.sonatype.gradle.plugins.scan") version "2.8.3"
    id("com.gorylenko.gradle-git-properties") version "2.4.2"
    id("com.vaadin") version "24.4.12"
}

vaadin {
    productionMode = true
}

val vaadinVersion by extra("24.4.12")

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation(group = "org.springframework.boot", name = "spring-boot-starter-freemarker")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-security")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-validation")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-data-jpa")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-mail")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-actuator")
    implementation(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core")
    implementation(group = "org.apache.poi", name = "poi-ooxml", version = "5.3.0")

    implementation("com.vaadin:vaadin-spring-boot-starter")
    implementation("org.parttio:line-awesome:2.0.0")

    runtimeOnly(group = "com.h2database", name = "h2")
    runtimeOnly(group = "org.mariadb.jdbc", name = "mariadb-java-client")

    developmentOnly(group = "org.springframework.boot", name = "spring-boot-devtools")

    testImplementation(group = "org.springframework.boot", name = "spring-boot-starter-test")
    testImplementation(group = "org.springframework.security", name = "spring-security-test")

    annotationProcessor(group = "org.springframework.boot", name = "spring-boot-configuration-processor")
    kapt(group = "org.springframework.boot", name = "spring-boot-configuration-processor")
}

dependencyManagement {
    imports {
        mavenBom("com.vaadin:vaadin-bom:$vaadinVersion")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    withType<KaptGenerateStubs> {
        exclude("com/example/buffer/issue/replicate/abcdef/dto/AbcdefAppointmentDTO.kt")
    }
    withType<Test> {
        useJUnitPlatform()
    }
    withType<KotlinCompile> {
        compilerOptions {
            freeCompilerArgs.add("-Xjsr305=strict")
            jvmTarget = JvmTarget.JVM_17
        }
    }
    withType<Wrapper> {
        gradleVersion = "8.10.1"
    }
    named<Jar>("jar") {
        enabled = false
    }
    withType<BootJar> {
        launchScript()
        archiveFileName.set("buffer.jar")
    }
}

springBoot {
    buildInfo()
}

group = "com.example.buffer.issue"
version = "1.0.0"
