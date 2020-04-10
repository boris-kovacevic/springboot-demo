FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

#./mvnw com.google.cloud.tools:jib-maven-plugin:dockerBuild -Dimage=springboot/user-docker

#docker run -p 3306:3306 --name user -e MYSQL_ROOT_PASSWORD=root -d mysql