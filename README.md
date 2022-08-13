# Se Mudando

[![Docker Pulls](https://img.shields.io/docker/pulls/semudando/web)](https://hub.docker.com/repository/docker/semudando/web)
[![Docker Image Version (tag latest semver)](https://img.shields.io/docker/v/semudando/web/1.0.0?label=image%20version)](https://hub.docker.com/repository/docker/semudando/web)


## Launching with Docker-compose

1. Clone repository
2. `docker-compose up -d`
3. Server should be accessible in configured host and label.

If you don't have caddy setup, you can remove caddy and open the port directly:
```
version: "3.8"

services:
  web:
    image: semudando/web:version
    ports:
      - "8080:8080"
```
