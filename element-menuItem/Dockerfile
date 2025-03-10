FROM eclipse-temurin:17.0.6_10-jre
ENV SERVER_PORT=8080
EXPOSE 8080
COPY target/element-menuItem-0.0.1-SNAPSHOT.jar /opt/element-menuItem.jar
CMD ["java", "-jar", "/opt/element-menuItem.jar"]