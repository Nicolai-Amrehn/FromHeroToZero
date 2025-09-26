FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy Maven wrapper and pom.xml first for better caching
COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .

# Make mvnw executable and install dependencies
RUN chmod +x mvnw && \
    ./mvnw dependency:go-offline -B

# Copy source code
COPY src/ src/

# Package the application
RUN ./mvnw clean package -DskipTests

# Run the application
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/FromHeroToZero-0.0.1-SNAPSHOT.jar"]