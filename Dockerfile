FROM openjdk:latest

RUN mkdir /app
WORKDIR /app
COPY . ./

ENTRYPOINT ["sh", "./gradlew", "bootRun"]
