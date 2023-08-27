FROM openjdk:17
ARG JAR_FILE=target/*.jar}
COPY${JAR_FILE} bquitopassive.jar
ENTRYPOINT ["java", "-jar", "/bquitopassive.jar"]
EXPOSE 3000