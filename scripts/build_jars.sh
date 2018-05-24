#!/usr/bin/env bash

cd ../nwt-api-gateway
mvn clean package -Dmaven.test.skip=true

cd ../nwt-cinema-auth
mvn clean package -Dmaven.test.skip=true

cd ../nwt-cinema-movies
mvn clean package -Dmaven.test.skip=true

cd ../nwt-cinema-projections
mvn clean package -Dmaven.test.skip=true

cd ../nwt-cinema-reservations
mvn clean package -Dmaven.test.skip=true

cd ../nwt-eureka-server
mvn clean package -Dmaven.test.skip=true
