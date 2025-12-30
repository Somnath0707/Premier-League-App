FROM openjdk:27-ea-trixie
ADD target/Premier-League-App.jar Premier-League-App.jar
ENTRYPOINT ["java", "-jar", "/Premier-League-App.jar"]