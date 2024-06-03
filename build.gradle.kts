plugins {
	java
	id("org.springframework.boot") version "3.2.6"
	id("io.spring.dependency-management") version "1.1.5"
	id("io.swagger.core.v3.swagger-gradle-plugin") version "2.2.22"
//	id("org.springdoc.openapi-gradle-plugin") version "1.8.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

//	implementation("org.springdoc:springdoc-openapi-ui:1.2.34")
//	implementation("io.swagger.core.v3:swagger-core:2.2.22")
//	implementation("io.swagger.core.v3:swagger-models:2.2.22")
//	implementation("io.swagger.parser.v3:swagger-parser:2.0.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
