FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/QAP2-4Sem-1.0-SNAPSHOT.jar /app/golfclub-tournament-api.jar
CMD ["java", "-jar", "/app/golfclub-tournament-api.jar"]
