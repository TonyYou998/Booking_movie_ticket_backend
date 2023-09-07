
# everthing works ok on my local docker
FROM openjdk:11-jdk-slim as build
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]

