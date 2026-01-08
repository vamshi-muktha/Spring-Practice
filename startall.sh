#!/bin/bash

echo "Starting Eureka Server..."
cd DiscoveryServer
mvn spring-boot:run &
sleep 15

echo "Starting Config Server..."
cd ../ConfigServer
mvn spring-boot:run &
sleep 15

echo "Starting API Gateway..."
cd ../api-gateway
mvn spring-boot:run &
sleep 150

echo "Starting User Service..."
cd ../employee-service
mvn spring-boot:run &
sleep 10

echo "Starting Order Service..."
cd ../dept-service
mvn spring-boot:run &
