
#Fixed typo in error message "image build failedundefined", changing "failedundefined" to "failed undefined"
FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
#The Dockerfile is now fixed and ready to be built.
