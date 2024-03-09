#!/bin/bash

docker build -t test .
docker run --name testcontainer -p 80:80 -d test