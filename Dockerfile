# STAGE 1 - BUILD
FROM gradle:8.11-jdk21 AS build

WORKDIR /app

COPY . .

RUN gradle bootJar --no-daemon

# STAGE 2 - RUN
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/build/libs/discografia-1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
