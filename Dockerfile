FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /workspace/app

# Copy gradle wrapper and related files
COPY gradle gradle
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .

# Ensure gradlew has execute permissions
RUN chmod +x gradlew

# Download dependencies (this layer is cached if build.gradle doesn't change)
RUN ./gradlew dependencies --no-daemon

# Copy source code
COPY src src

# Build the application
RUN ./gradlew build -x test --no-daemon

# Stage 2: Create a minimal JRE image to run the app
FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /workspace/app/build/libs/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
