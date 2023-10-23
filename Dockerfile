FROM openjdk:20-jdk-oraclelinux7
COPY arachni-articles-api/target/arachni-articles.jar arachni-articles.jar

ENV JAVA_OPTS = ""

EXPOSE 8080
CMD ["sh", "-c", "java -jar $JAVA_OPTS arachni-articles.jar"]