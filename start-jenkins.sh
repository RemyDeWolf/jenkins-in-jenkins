#!/bin/sh
docker build -t jenkins-in-jenkins .
docker run -p 8080:8080 -e JENKINS_PORT=8080 --rm -v /var/run/docker.sock:/var/run/docker.sock --name jenkins jenkins-in-jenkins
