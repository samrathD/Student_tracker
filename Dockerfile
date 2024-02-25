FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/student_tracker_app-0.0.1-SNAPSHOT.jar student_tracker_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","student_tracker_app.jar"]