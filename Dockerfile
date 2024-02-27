ARG JDK_VERSION=17-alpine
FROM eclipse-temurin:${JDK_VERSION}

LABEL maintener="Dimas Maryanto <software.dimas_m@icloud.com>"
ENV SERVER_PORT=8080

WORKDIR /usr/share/applications

ARG JAR_FILE="demo-nke-ops-1.0.0.jar"
COPY target/${JAR_FILE} spring-boot.jar

# Create folder & give access to read and write
ENV FILE_UPLOAD_STORED=/var/lib/spring-boot/data
RUN mkdir -p ${FILE_UPLOAD_STORED} && \
chmod -R 777 ${FILE_UPLOAD_STORED}/

VOLUME ${FILE_UPLOAD_STORED}/

ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "spring-boot.jar"]

CMD ["--server.port=${SERVER_PORT}"]
EXPOSE ${SERVER_PORT}/tcp
