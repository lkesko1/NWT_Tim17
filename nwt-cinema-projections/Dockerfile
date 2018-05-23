FROM openjdk:8-jre-alpine

COPY ./target/nwt-cinema-projections-0.0.1-SNAPSHOT.jar /usr/src/projections/
WORKDIR /usr/src/projections
EXPOSE 	8040
CMD ["java", "-jar", "nwt-cinema-projections-0.0.1-SNAPSHOT.jar"]

