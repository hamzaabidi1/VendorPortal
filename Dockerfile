FROM maven:3.6.3 AS maven
COPY . .
RUN mvn clean package -DskipTests=false

FROM openjdk:11
ADD target/vendorportal-0.0.1-SNAPSHOT.jar vendorportal-0.0.1-SNAPSHOT.jar
ADD ./vendorportal.sql /docker-entrypoint-initdb.d
ENTRYPOINT ["java","-jar","vendorportal-0.0.1-SNAPSHOT.jar"]