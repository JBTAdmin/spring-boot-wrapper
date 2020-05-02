FROM maven

COPY . /opt/source-code

WORKDIR /opt/source-code

RUN mvn clean install

WORKDIR ./target

EXPOSE 8989

CMD java -jar ./spring-boot-ehcache-0.0.1-SNAPSHOT.jar
