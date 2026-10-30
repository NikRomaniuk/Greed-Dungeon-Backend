# Greed-Dungeon - Back-End
#
# Commands cheat sheet:
#   Build:                  docker compose build
#   Run:                    docker compose up -d
#   Build & Run:            docker compose up -d --build
#
#   Stop:                   docker compose stop
#   Terminate:              docker compose down
#   Term (With Volumes):    docker compose down -v

# /////////////////////
# --- BUILD THE JAR ---
# /////////////////////

FROM eclipse-temurin:27-jdk AS build
WORKDIR /workspace

# Fisrt: Wrapper + pom.xml
# This layer stays cached until dependencies change
COPY mvnw pom.xml ./
COPY .mvn/ .mvn/
RUN chmod +x mvnw && ./mvnw -B dependency:go-offline

# Last: Sources
# They change most often
# Tests are skipped
COPY src/ src/
RUN ./mvnw -B package -DskipTests

# /////////////////////
# --- RUNTIME IMAGE ---
# /////////////////////

# Run the JAR
FROM eclipse-temurin:27-jre
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]