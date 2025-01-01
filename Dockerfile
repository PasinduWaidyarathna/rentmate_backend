FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/rentmate_backend-1.0.jar rentmate_backend-1.0.jar
EXPOSE 8080
CMD ["java", "-jar", "rentmate_backend-1.0.jar"]
