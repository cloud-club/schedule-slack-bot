FROM openjdk:17-jdk
COPY . /app
WORKDIR /app
ENTRYPOINT ["java", "-jar", "app.jar"]