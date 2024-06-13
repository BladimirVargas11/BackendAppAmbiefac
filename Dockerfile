# Especifica la plataforma para la imagen base
FROM --platform=linux/arm64/v8 alpine:latest

RUN apk add openjdk17
RUN apk update
RUN apk upgrade --available && sync
RUN mkdir -p /app
COPY target/*jar /app/.
CMD ["/bin/sh","-c","java -jar /app/*.jar"]