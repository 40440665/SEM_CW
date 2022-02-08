FROM openjdk:latest
COPY ./target/classes/com /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "group2.SEM"]
