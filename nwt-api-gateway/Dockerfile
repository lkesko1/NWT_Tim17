FROM openjdk:8-jre-alpine
COPY ./target/nwt-api-gateway-0.0.1-SNAPSHOT.jar /usr/src/gateway/
WORKDIR /usr/src/gateway
EXPOSE 8080
CMD ["java", "-jar", "nwt-api-gateway-0.0.1-SNAPSHOT.jar"]
