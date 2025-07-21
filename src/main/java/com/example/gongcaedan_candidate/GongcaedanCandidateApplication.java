package com.example.gongcaedan_candidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class GongcaedanCandidateApplication {

    public static void main(String[] args) {
        try {
            // ✅ 1. .env 파일 로드
            Dotenv dotenv = Dotenv.configure()
                    .filename(".env")       // 기본은 .env
                    .ignoreIfMissing()      // 없으면 무시 (Docker 환경 대응)
                    .load();

            // ✅ 2. 환경변수가 존재할 경우에만 시스템에 설정
            if (dotenv.get("DB_URL") != null)
                System.setProperty("DB_URL", dotenv.get("DB_URL"));

            if (dotenv.get("DB_USERNAME") != null)
                System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));

            if (dotenv.get("DB_PASSWORD") != null)
                System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        } catch (Exception e) {
            System.out.println("⚠️ .env 환경 변수 로딩 실패 또는 무시됨: " + e.getMessage());
        }

        // ✅ 3. Spring Boot 앱 실행
        SpringApplication.run(GongcaedanCandidateApplication.class, args);
    }
}
