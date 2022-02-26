import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springCloudVersion = "2.2.1.RELEASE"

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
	kotlin("plugin.jpa") version "1.5.31"
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-vault-dependencies:${springCloudVersion}")
	}
}

group = "com.peter"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	//MySQL
	implementation("mysql:mysql-connector-java:8.0.21")

	// Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("com.ninja-squad:springmockk:3.1.0")
	implementation("io.github.serpro69:kotlin-faker:1.9.0")
	implementation("org.junit.jupiter:junit-jupiter:5.8.2")


	// Vault
//	implementation("org.springframework.cloud:spring-cloud-starter-vault-config")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
