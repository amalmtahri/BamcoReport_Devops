FROM openjdk:11
EXPOSE 8080
ADD target/bamcoreport.jar bamcoreport.jar
ENTRYPOINT ["java","-jar","/bamcoreport.jar"]