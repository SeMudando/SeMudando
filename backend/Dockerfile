FROM java:alpine
EXPOSE 9090
RUN mkdir /app
COPY build/install/backend/ /app/
WORKDIR /app/bin
ENV STRIPE_API_KEY="${STRIPE_API_KEY}"
CMD "./backend"