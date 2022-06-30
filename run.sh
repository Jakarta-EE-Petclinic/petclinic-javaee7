#!/usr/bin/env bash

#./mvnw

#./mvnw -Pglassfish-managed
./mvnw -Pwildfly-managed -DskipTests=true
