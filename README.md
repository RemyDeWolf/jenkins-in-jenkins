# jenkins-in-jenkins
Start a Jenkins server from within itself using Docker.

<img src="jenkins-recursive.png"/>

Have you ever heard of running Docker within Docker?
Now, image you have a Jenkins container which can run Docker, would that image be able to start itself?

This image includes a Jenkins server with Docker installed.
Jenkins comes pre-configured with job called 'start-new-jenkins'. Run this job to start another identical instance of Jenkins on the host. The process can be repeated recursively. To prevent reusing the same TCP port, the port is incremented at each run.

# Usage

```
docker run -p 8080:8080 -e JENKINS_PORT=8080 --rm -v /var/run/docker.sock:/var/run/docker.sock --name jenkins remydewolf/jenkins-in-jenkins
```

# How does it work:

The Dockerfile extends Jenkins official image and installs docker from the Debian repo. When starting the container, the volume '/var/run/docker.sock' is mounted from the host to the container. Every time a Jenkins instance is started, the container is actually started on the host.

# Resources
- [Docker in Docker! Official Image](https://hub.docker.com/_/docker/)
- [About /var/run/docker.sock](https://medium.com/lucjuggery/about-var-run-docker-sock-3bfd276e12fd)
- [Jenkins Docker in Docker (DinD) ](https://tripdubroot.com/jenkins-docker-in-docker-dind-2040cc90eeab)
