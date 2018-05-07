FROM openjdk:8-jre-alpine
COPY ./target/nwt-eureka-server-0.0.1-SNAPSHOT.jar /usr/src/eureka-server/
WORKDIR /usr/src/eureka-server
EXPOSE 8761
CMD ["java", "-jar", "nwt-eureka-server-0.0.1-SNAPSHOT.jar"]
