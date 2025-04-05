FROM openjdk:17-jdk-slim

WORKDIR /app-ddd

COPY target/*.jar app.jar

EXPOSE 5002

ENTRYPOINT ["java", "-jar","app.jar"]