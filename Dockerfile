# Use Java 17 image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy everything
COPY . .
RUN chmod +x mvnw
# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/TodoDeploy-0.0.1-SNAPSHOT.jar"]