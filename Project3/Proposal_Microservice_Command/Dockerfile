FROM openjdk:8-jre-alpine
ADD target/Proposal_Command-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]