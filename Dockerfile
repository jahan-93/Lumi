FROM openjdk:24-ea-34-jdk-slim

COPY build/libs/security-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]