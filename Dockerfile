FROM openjdk:11.0.11-oracle

ARG JAR_FILE
ARG CONTEXT

COPY ${JAR_FILE} ${CONTEXT}.jar
ENTRYPOINT ["java","-jar","app.jar"]