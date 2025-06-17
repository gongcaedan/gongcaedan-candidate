package com.example.gongcaedan_candidate.controller;

import com.example.gongcaedan_candidate.entity.Candidate;
import com.example.gongcaedan_candidate.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateRepository candidateRepository;

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @PostMapping
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        candidate.setCreatedAt(LocalDateTime.now()); // 생성일 자동 설정
        return candidateRepository.save(candidate);
    }
}
