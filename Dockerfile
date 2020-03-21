FROM maven:3.6.1-jdk-11 AS builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -Pdev -Dmaven.test.skip=true

FROM adoptopenjdk/openjdk11:jre-11.0.3_7
WORKDIR /app
COPY --from=builder /usr/src/app/target/*.jar /app/app.jar
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
CMD ["sh", "-c", "exec java -jar app.jar"]
