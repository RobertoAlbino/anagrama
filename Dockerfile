FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q test package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/classes /app/classes
CMD ["java","-cp","/app/classes","org.anagrama.Anagrama","abc"]
