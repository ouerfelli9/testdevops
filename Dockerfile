FROM openjdk:8
ADD target/testProject-1.0.jar operateurimage.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "operateurimage.jar"]