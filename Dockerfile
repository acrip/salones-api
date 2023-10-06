FROM openjdk:17

COPY target/salones-0.0.1-SNAPSHOT.jar salones.jar

ENTRYPOINT ["java", "-jar", "salones.jar"]
