FROM gradle:8-jdk21-alpine
COPY . .
RUN ["./gradlew", "bootJar"]
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./app.jar"]
