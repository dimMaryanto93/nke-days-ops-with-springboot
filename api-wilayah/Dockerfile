ARG JDK_VERSION=17-alpine
FROM --platform=amd64 eclipse-temurin:${JDK_VERSION}
LABEL maintener="Dimas Maryanto <software.dimas_m@icloud.com>"

ENV SERVER_PORT=8080

# setup application
WORKDIR /usr/share/applications

ARG JAR_FILE="microservice-api-wilayah-1.0.0.jar"
COPY target/${JAR_FILE} spring-boot.jar

ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "spring-boot.jar"]

CMD ["--server.port=${SERVER_PORT}"]
EXPOSE ${SERVER_PORT}/tcp