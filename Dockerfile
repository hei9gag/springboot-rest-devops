FROM eclipse-temurin:11.0.19_7-jre-jammy as builder
VOLUME /tmp
WORKDIR application
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract
#ENTRYPOINT ["java","-jar","/application/app.jar"]

FROM eclipse-temurin:11.0.19_7-jre-jammy
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

