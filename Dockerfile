

FROM openjdk:17

COPY target/homeloan.jar homeloan.jar

EXPOSE 9090 

ENTRYPOINT ["java", "-jar", "homeloan.jar"]  
