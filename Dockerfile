FROM openjdk:latest
WORKDIR /cbg/data/result/screenshots
WORKDIR /cbg/data/uploadsFiles
WORKDIR /cbg/data
ADD /target/CallbackGen-0.0.1-SNAPSHOT.jar callback-gen.jar
ENTRYPOINT ["java", "-jar", "callback-gen.jar"]