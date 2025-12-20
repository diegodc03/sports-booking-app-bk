# --------------------
# STAGE 1: COMPILACIÓN (BUILD)
# --------------------
# Actualizado a Maven con Eclipse Temurin 21
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos archivos de dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos código y compilamos
COPY src ./src
RUN mvn clean package -DskipTests

# --------------------
# STAGE 2: EJECUCIÓN (RUNTIME)
# --------------------
# Actualizado a JRE 21 (versión ligera Alpine)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el JAR
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]