#!/usr/bin/env bash

# Remove DB docker first to ensure that we have a clean database
LINE="$(docker ps -a | grep pg_container)"
echo "${LINE}"
IFS=' ' read -ra ADDR <<< "$LINE"
for i in "${ADDR[@]}"; do
    DOCKER_NAME=${ADDR}d
    break
done
if [[ -z "$DOCKER_NAME" ]]
then
    echo 'No Postgres container found!'
else
    echo "Found Docker Id ${ADDR} REMOVING..."
    docker rm ${DOCKER_NAME}
fi

# Build JARs
cd ../nwt-api-gateway
mvn clean package -Dmaven.test.skip=true

cd ../nwt-eureka-server
mvn clean package -Dmaven.test.skip=true

cd ../nwt-cinema-auth
mvn clean package -Dmaven.test.skip=true

cd ../nwt-cinema-movies
mvn clean package -Dmaven.test.skip=true

cd ../nwt-cinema-projections
mvn clean package -Dmaven.test.skip=true

cd ../nwt-cinema-reservations
mvn clean package -Dmaven.test.skip=true

# Build and run containers
cd ../
docker-compose build && docker-compose up
