# Usa a imagem do Maven para compilar a aplicacao
FROM maven:3.8.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

#Usa uma iamgem do JDK para rodar o .jar gerado
FROM eclipe-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]