package com.example.gongcaedan_candidate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GongcaedanCandidateApplication{

    public static void main(String[] args) {
        // 1. .env 파일 로드
        Dotenv dotenv = Dotenv.configure()
                .filename(".env") // 기본이 .env이므로 생략 가능
                .ignoreIfMissing() // 없으면 무시
                .load();

        // 2. 환경변수로 설정
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        // 3. Spring 실행
        SpringApplication.run(GongcaedanCandidateApplication.class, args);
    }
}
