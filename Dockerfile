FROM openjdk:latest
COPY target/BookingMovieTicket-0.0.2-SNAPSHOT.jar app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]