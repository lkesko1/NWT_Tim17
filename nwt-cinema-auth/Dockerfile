FROM openjdk:8-jre-alpine

COPY ./target/nwt-cinema-auth-0.0.1-SNAPSHOT.jar /usr/src/auth/
WORKDIR /usr/src/auth
EXPOSE 8020
CMD ["java", "-jar", "nwt-cinema-auth-0.0.1-SNAPSHOT.jar"]

