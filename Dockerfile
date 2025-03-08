# Etapa de construcción (build)
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar y descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar código fuente y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución (runtime)
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/pianomaster2-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponer el puerto
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
