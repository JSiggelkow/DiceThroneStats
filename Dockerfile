FROM maven:3.9.4-eclipse-temurin-21-alpine AS maven-builder

COPY src /app/src
COPY pom.xml /app
COPY ./entrypoint.sh /app

RUN mvn -f /app/pom.xml clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

COPY --from=maven-builder /app/target/DiceThroneStats-0.1.jar /app-service/DiceThroneStats-0.1.jar
COPY ./entrypoint.sh /app-service

WORKDIR /app-service

RUN chmod +x /app-service/entrypoint.sh

EXPOSE 8080
ENTRYPOINT ["/app-service/entrypoint.sh", "java", "-jar", "DiceThroneStats-0.1.jar"]