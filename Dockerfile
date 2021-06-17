FROM openjdk:8-jdk-alpine
COPY target/football-buzz-0.0.1-SNAPSHOT.jar football-buzz-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","football-buzz-0.0.1-SNAPSHOT.jar"]