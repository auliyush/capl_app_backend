# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /capl_app_backend

# Copy the JAR file built from your Spring Boot application
# Replace 'your-app.jar' with the actual name of the JAR file in the target directory
COPY target/capl-0.0.1-SNAPSHOT.jar capl.jar

# Expose the port your Spring Boot app runs on (typically 8080)
EXPOSE 8080

# Set the MongoDB URI environment variable
# Render or Docker environment will need to provide this value securely
ENV MONGODB_URI="mongodb+srv://Capl_db:Forgot%40123@capl-codingage.irezg.mongodb.net/capl?retryWrites=true&w=majority&appName=CAPL-CodingAge"

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "capl.jar"]
