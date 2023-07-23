# Fetching latest version of Java
FROM openjdk:11-jdk-slim

# Copy the jar file into our app
COPY target/spring-boot-scheduler-demo-0.0.1-SNAPSHOT.jar /app.jar

# Exposing port 
EXPOSE 9090

ENTRYPOINT ["java","-jar","/app.jar"]