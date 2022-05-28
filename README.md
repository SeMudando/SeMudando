# Se Mudando


## Launching with Docker-compose

1. Clone repository
2. `docker-compose up -d`
3. Server should be accessible in configured host and label.

If you don't have caddy setup, you can remove caddy and open the port directly:
```
version: "3.8"

services:
  web:
    image: danjellz/http-server
    ports:
      - "8080:8080"
    volumes:
      - ./web:/public
```
