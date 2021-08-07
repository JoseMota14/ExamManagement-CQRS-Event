FROM openjdk:8-jre-alpine
ADD target/Proposal_Query-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","/app.jar"]