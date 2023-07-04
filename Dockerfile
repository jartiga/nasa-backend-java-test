# First stage: build the application
FROM maven:3.8.3-jdk-11 as builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ ./src/
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]