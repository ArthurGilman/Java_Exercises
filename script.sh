#!/bin/bash

mvn install
docker build --build-arg PORT=${PORT} -t vydii/myapp .
docker run --name myapp -p 8080:${PORT} vydii/myapp
