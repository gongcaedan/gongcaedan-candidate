# 1. JDK 기반의 경량 이미지 사용
FROM openjdk:17-jdk-slim

# 2. JAR 파일을 컨테이너 내부로 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 3. 내부 포트 설정 (application.yml의 8080)
EXPOSE 8080

# 4. 실행 명령
ENTRYPOINT ["java", "-jar", "/app.jar"]
