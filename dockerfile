# 使用輕量級 JDK 17 基底映像
FROM eclipse-temurin:17-jdk-alpine

# 建立工作目錄
WORKDIR /app

# 複製打包好的 JAR 檔
COPY target/TwitterDemo-0.0.1-SNAPSHOT.jar app.jar

# 啟動應用
ENTRYPOINT ["java", "-jar", "app.jar"]