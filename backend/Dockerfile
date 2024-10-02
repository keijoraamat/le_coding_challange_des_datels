FROM openjdk:17-jdk-alpine

# Create a non-root user and group
RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY build/libs/*.jar app.jar

# Change ownership of the application files to the non-root user
RUN chown -R spring:spring /app

# Switch to the non-root user
USER spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
