FROM openjdk:latest

RUN mkdir /app
WORKDIR /app
COPY . ./

RUN sudo ./gradlew --full-stacktrace -q build

CMD sudo ./gradlew bootRun
