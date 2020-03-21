FROM openjdk:8-jdk-slim-stretch
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE}  /app.jar
RUN apt-get -qq update
RUN apt-get install -y wget
ENV TZ Australia/Sydney

EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]

# LOGGING

