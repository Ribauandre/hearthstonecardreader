#!/bin/bash

./gradlew clean build
./gradlew bootRun

cd ./src/main/ui
yarn install
yarn start
