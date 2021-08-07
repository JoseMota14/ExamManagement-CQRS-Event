FROM openjdk:8-jre-alpine
ADD target/Configuration_Query-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/app.jar"]