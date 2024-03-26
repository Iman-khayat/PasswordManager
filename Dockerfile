# Base image for Java application
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy the application jar
COPY target/*.jar app.jar

# Expose port for the application
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]

# Additional considerations (optional):

# Environment variables for database connection details
# ENV DB_HOST=postgres
# ENV DB_PORT=5432
# ENV DB_USERNAME=password_manager
# ENV DB_PASSWORD=your_password

# Copy additional resources (configuration files)
# COPY application.properties app/
