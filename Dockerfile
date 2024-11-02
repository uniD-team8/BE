# 1. OpenJDK 이미지 가져오기 (멀티스테이지 빌드)
FROM openjdk:17-jdk-slim as builder

# 2. 빌드 단계
WORKDIR /app
COPY . .
RUN ./gradlew bootJar

# 3. 런타임 단계
FROM openjdk:17-jdk-slim
WORKDIR /app

# JAR 파일을 빌드 컨테이너에서 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 4. 포트 노출 및 애플리케이션 실행
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
