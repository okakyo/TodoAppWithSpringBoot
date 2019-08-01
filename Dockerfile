FROM openjdk:latest

RUN mkdir /app
WORKDIR /app
COPY . ./

RUN ./gradlew --full-stacktrace -q build

CMD ./gradlew bootRun
