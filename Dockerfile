FROM openjdk:latest
COPY ./target/SEM_CW.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEM_CW.jar", "db:3306", "30000"]