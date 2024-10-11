

FROM openjdk:1.8

COPY target/homeloan.jar homeloan.jar

EXPOSE 9090 

ENTRYPOINT ["java", "-jar", "homeloan.jar"]  
