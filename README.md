# spring-boot-example
Base project for spring boot applications

## Environment Setup

0. Download openjdk-11.0.1_osx-x64_bin.tar.gz from https://jdk.java.net/11/

0. Install gradle
   ```
   brew install gradle
   ```

1. Copy config/application.properties.template and configure your local db connection
   ```
   cp config/application.properties.template config/application.properties
   ```


2. Enable gradle deamon: vi ~/.gradle/gradle.properties
   ```
   org.gradle.caching=true
   org.gradle.daemon=true
   ```

3. Start app
   ```
   gradle bootRun
   ```


## IntelliJ

1. Install Lombok plugin

2. Enable annotation processing
   Settings -> Compiler -> Annotation Processors