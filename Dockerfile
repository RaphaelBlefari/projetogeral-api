FROM openjdk:8-jdk-alpine
ADD target\ProjetoGeral-0.0.1.jar target/app.jar
RUN /bin/sh -c 'touch target/app.jar'
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=default","target/app.jar"]
