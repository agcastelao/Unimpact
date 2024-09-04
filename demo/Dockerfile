FROM maven:3.9.9-eclipse-temurin-22 AS build

WORKDIR /app

COPY demo/pom.xml .

RUN mvn dependency:go-offline

COPY demo/src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:22-jdk

WORKDIR /app

# Copia o JAR da aplicação da etapa anterior
COPY --from=build /app/target/*.jar /app/unimpact.jar

# Expõe a porta que a aplicação Spring Boot vai usar
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/unimpact.jar"]