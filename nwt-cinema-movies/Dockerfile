FROM openjdk:8-jre-alpine

COPY ./target/nwt-cinema-movies-0.0.1-SNAPSHOT.jar /usr/src/movies/
WORKDIR /usr/src/movies
EXPOSE 8030
CMD ["java", "-jar", "nwt-cinema-movies-0.0.1-SNAPSHOT.jar"]
