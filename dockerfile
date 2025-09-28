FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .

RUN chmod +x mvnw && \
    ./mvnw dependency:go-offline -B

COPY src/ src/

RUN ./mvnw clean package -DskipTests

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/FromHeroToZero-0.0.1-SNAPSHOT.jar"]