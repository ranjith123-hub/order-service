#Use an official OpenJDK 21 image from the Docker Hub
FROM openjdk:21
# Set the working directory inside the container
WORKDIR /app
# Copy the compiled Java application JAR file into the container
COPY ./target/order-service.jar /app
# Expose the port on which the application will run
EXPOSE 8080
# Command to run the  application
CMD ["java", "-jar", "order-service.jar"]