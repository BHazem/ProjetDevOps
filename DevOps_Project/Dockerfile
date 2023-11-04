FROM openjdk:8-jre-alpine
ARG NEXUS_URL=http://192.168.1.27:8081/repository/maven-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar
RUN wget -O /DevOps_Project-2.1.jar $NEXUS_URL
CMD ["java", "-jar", "/DevOps_Project-2.1.jar"]
EXPOSE 80