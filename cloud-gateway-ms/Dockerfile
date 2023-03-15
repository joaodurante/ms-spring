FROM maven:3.9.0-amazoncorretto-19 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:19.0.2
WORKDIR /app
COPY --from=build ./build/target/*.jar ./application.jar
EXPOSE 8761
ARG KEYCLOAK_HOST=ms-keycloak
ARG KEYCLOAK_PORT=8081
ARG KEYCLOAK_REALM=ms-spring-realm
ARG EUREKA_HOST=ms-eureka
ENTRYPOINT java -jar -Dspring.profiles.active=prod application.jar