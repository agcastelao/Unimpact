FROM maven:3.9.9-eclipse-temurin-22 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .

RUN mvn clean compile -DskipTests

# Expõe a porta que a aplicação Spring Boot vai usar
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["mvn", "spring-boot:run"]