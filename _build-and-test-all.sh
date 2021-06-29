#! /bin/bash

set -e

export SPRING_PROFILES_ACTIVE=${DATABASE?}

dockerall="./gradlew ${DATABASE}${MODE}${BROKER}Compose"

${dockerall}Down
${dockerall}Up

./gradlew :eventuate-tram-examples-jdbc-${BROKER}:cleanTest :eventuate-tram-examples-jdbc-${BROKER}:test

${dockerall}Down
