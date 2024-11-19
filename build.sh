#!/bin/sh

set -x

# Maven build
MAVEN_OPTS="-Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN -Dorg.slf4j.simpleLogger.showDateTime=true -Djava.awt.headless=true"
mvn ${MAVEN_OPTS} clean deploy com.netcracker.om.tls.maven.plugin:dtrust-maven-plugin:4.2.2:dtrust -f ./opensearch-filter-plugin/pom.xml

DOCKER_FILE=docker/Dockerfile

for docker_image_name in $DOCKER_NAMES; do
 docker build \
 --file=${DOCKER_FILE} \
 --pull \
 -t ${docker_image_name} \
 .
done