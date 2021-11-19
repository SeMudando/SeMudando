FROM java:alpine
EXPOSE 9090
RUN mkdir /app
COPY build/install/backend/ /app/
WORKDIR /app/bin
CMD "./backend"