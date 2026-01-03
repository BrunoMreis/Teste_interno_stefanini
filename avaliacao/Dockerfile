
# Etapa 1: Build com Maven e JDK 25
FROM 3.9.11-eclipse-temurin-25-alpine AS build
WORKDIR /loajaApp
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


# Etapa 2: Imagem final com JRE 25
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]