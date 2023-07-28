FROM rsunix/yourkit-openjdk17

ADD target/nomDemoTest.jar nomDemoTest.jar
ENTRYPOINT ["java", "-jar","nomDemoTest.jar"]
EXPOSE 8080