plugins {
    java
    id("org.springframework.boot") version "3.2.5" 
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.mesaya"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Starter Base
    implementation("org.springframework.boot:spring-boot-starter-web")
    
    // 1. SOLUCIÓN A LOS ERRORES DE VALIDACIÓN (jakarta.validation)
    implementation("org.springframework.boot:spring-boot-starter-validation")
    
    // 2. SOLUCIÓN A LOS ERRORES DE SECURITY (BCryptPasswordEncoder)
    implementation("org.springframework.boot:spring-boot-starter-security")
    
    // Si usas Base de Datos SQLite (Hibernate ORM)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // Dependencia nativa para soportar SQLite en ambientes modernos de JPA
    implementation("org.xerial:sqlite-jdbc:3.45.1.0")
    implementation("org.hibernate.orm:hibernate-community-dialects:6.4.4.Final")
    
    // Herramientas útiles
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    
    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}
tasks.withType<Test> {
    useJUnitPlatform()
}
