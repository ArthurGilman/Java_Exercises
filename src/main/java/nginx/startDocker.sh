#!/bin/bash

docker build -t test .
docker run --name testcontainer -p 81:81 -d test