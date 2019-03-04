FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD spring-cloud-service-a.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8800
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]