FROM openjdk:20-jdk-oraclelinux7
COPY arachni-article-api/target/arachni-article.jar arachni-article.jar

ENV JAVA_OPTS = ""

EXPOSE 8080
CMD ["sh", "-c", "java -jar $JAVA_OPTS arachni-article.jar"]