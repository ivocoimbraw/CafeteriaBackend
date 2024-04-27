FROM maven:3.8.8-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk17:17.0.1-jdk-slim
COPY --from=build /target/apirest0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "demo.jar" ]