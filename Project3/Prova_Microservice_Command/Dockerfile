FROM openjdk:8-jre-alpine
ADD target/Prova_Command-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8088
ENTRYPOINT ["java","-jar","/app.jar"]