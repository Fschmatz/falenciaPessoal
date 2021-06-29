FROM openjdk:8-jdk-alpine

ARG JAR_FILE
ARG CONTEXT

COPY ${JAR_FILE} ${CONTEXT}.jar
ENTRYPOINT ["java","-jar","app.jar"]