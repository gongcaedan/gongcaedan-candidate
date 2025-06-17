package com.example.gongcaedan_candidate.config;

import com.example.gongcaedan_candidate.entity.Candidate;
import com.example.gongcaedan_candidate.repository.CandidateRepository;
import com.example.gongcaedan_candidate.repository.PartyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.gongcaedan_candidate.entity.Party;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class DummyDataConfig {

    @Bean
    CommandLineRunner initCandidates(CandidateRepository repo, PartyRepository partyRepo) {
        return args -> {
            Party party1 = partyRepo.findById(1L).orElseGet(() ->
                    partyRepo.save(Party.builder()
                            .name("진보당")
                            .logoUrl("http://example.com/progressive.png")
                            .description("서민을 위한 정당입니다.")
                            .build())
            );

            Party party2 = partyRepo.findById(2L).orElseGet(() ->
                    partyRepo.save(Party.builder()
                            .name("보수당")
                            .logoUrl("http://example.com/conservative.png")
                            .description("전통을 중시하는 정당입니다.")
                            .build())
            );

            if (repo.count() == 0) {
                repo.save(Candidate.builder()
                        .name("홍길동")
                        .birthDate(LocalDate.of(1980, 3, 15))
                        .gender("M")
                        .party(party1)
                        .profileImageUrl("http://example.com/hong.jpg")
                        .createdAt(LocalDateTime.now())
                        .build());

                repo.save(Candidate.builder()
                        .name("이영희")
                        .birthDate(LocalDate.of(1975, 7, 2))
                        .gender("F")
                        .party(party2)
                        .profileImageUrl("http://example.com/lee.jpg")
                        .createdAt(LocalDateTime.now())
                        .build());
            }
        };
    }
}
