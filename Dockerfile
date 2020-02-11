FROM openjdk:latest
COPY ./target/popInfo-0.1.0.3-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "popInfo-0.1.0.3-jar-with-dependencies.jar"]