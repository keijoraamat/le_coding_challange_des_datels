FROM openjdk:17-jdk-alpine

RUN apk upgrade --no-cache

# Create a non-root user and group
RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY build/libs/*.jar app.jar

USER spring:spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
