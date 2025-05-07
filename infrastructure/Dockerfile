# 1. Build stage
FROM eclipse-temurin:24-jdk-alpine AS build

WORKDIR /app

# Install Maven
RUN apk add --no-cache maven

# Copy the entire project and build it
COPY . .
RUN mvn clean package -DskipTests

# 2. Run stage
FROM eclipse-temurin:24-jdk-alpine
WORKDIR /app

# Copy the infrastructure JAR file from the build stage
COPY --from=build /app/infrastructure/target/infrastructure-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

