FROM openjdk:8-jre-alpine
ADD target/Configuration_Command-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","/app.jar"]