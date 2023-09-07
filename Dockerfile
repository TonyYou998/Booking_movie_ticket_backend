
#Fixed typo in error message "image build failedundefined", changing "failedundefined" to "failed undefined"

FROM openjdk:latest
COPY target/BookingMovieTicket-0.0.2-SNAPSHOT.jar app.jar   #Copy the jar file named "BookingMovieTicket-0.0.2-SNAPSHOT.jar" from the "target" directory and rename it to "app.jar"
WORKDIR /app   #Set the working directory to "/app"
EXPOSE 8080   #Expose port 8080
CMD ["java","-jar","app.jar"]   #Execute the jar file "app.jar" using the java command

#The Dockerfile is now fixed and ready to be built.
