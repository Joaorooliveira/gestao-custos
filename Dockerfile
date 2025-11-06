# Usa a imagem do Maven para compilar a aplicacao
FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY src/main/java/br/com/joaov/gestaocustos .
RUN mvn clean package -DskipTests

#Usa uma iamgem do JDK para rodar o .jar gerado
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]