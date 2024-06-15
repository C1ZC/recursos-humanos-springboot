# Etapa de compilación
FROM maven:3.8.1-openjdk-11-slim AS build
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -B -f pom.xml clean package -DskipTests

# Etapa de ejecución
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /workspace/target/rrss-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java","-jar","rrss-0.0.1-SNAPSHOT.jar"]