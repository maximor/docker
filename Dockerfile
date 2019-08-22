#FROM haproxy:1.7
#COPY haproxy.cfg /usr/local/etc/haproxy/haproxy.cfg
FROM openjdk:8
ADD build/libs/docker-0.0.1-8080.jar aplicacion-8080.jar
ENTRYPOINT ["java", "-jar", "aplicacion-8080.jar"]