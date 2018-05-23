FROM openjdk:8-jre-alpine

COPY ./target/nwt-cinema-reservations-0.0.1-SNAPSHOT.jar /usr/src/reservations/
WORKDIR /usr/src/reservations
EXPOSE 8050
CMD ["java", "-jar", "nwt-cinema-reservations-0.0.1-SNAPSHOT.jar"]

