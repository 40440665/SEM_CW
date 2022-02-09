FROM openjdk:latest
COPY ./target/CW-0.1.0.1.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "CW-0.1.0.1.jar"]