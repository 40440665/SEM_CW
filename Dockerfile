FROM openjdk:latest
COPY ./target/SEM_CW-0.1.0.3-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods-0.1.0.3-jar-with-dependencies.jar"]