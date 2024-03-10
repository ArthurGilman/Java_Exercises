FROM eclipse-temurin:17-jdk-alpine
ARG PORT
ENV PORT="${PORT}"
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]