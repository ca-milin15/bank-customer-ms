FROM openjdk:17-alpine
COPY target/bank-customer-ms-0.0.1-SNAPSHOT.jar bank-customer-ms-0.0.1-SNAPSHOT.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","bank-customer-ms-0.0.1-SNAPSHOT.jar"]
