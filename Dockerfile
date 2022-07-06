FROM maven:3.6.3 AS maven
COPY src /home/app/src
COPY vendorportal.sql /home/app/vendorportal.sql
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -Dmaven.test.skip=true

FROM openjdk:11
COPY --from=maven /home/app/target/*.jar vendorportal-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","vendorportal-0.0.1-SNAPSHOT.jar"]