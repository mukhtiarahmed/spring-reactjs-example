FROM openjdk:8-jdk-alpine

VOLUME /tmp
EXPOSE 9292
COPY target/oauth-mongodb-1.0.jar app.jar
RUN sh -c 'touch /app.jar'

ENTRYPOINT java -Dspring.data.mongodb.uri=${MONGO_URI} -Djava.security.egd=file:/dev/./urandom  -jar app.jar