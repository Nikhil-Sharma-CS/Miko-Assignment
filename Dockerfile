FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY target/Miko-Assignment-0.0.1-SNAPSHOT.jar miko.jar

EXPOSE 8080

CMD ["java", "-jar", "miko.jar"]
