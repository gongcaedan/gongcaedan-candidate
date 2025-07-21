package com.example.gongcaedan_candidate.controller;

import com.example.gongcaedan_candidate.entity.Candidate;
import com.example.gongcaedan_candidate.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import com.example.gongcaedan_candidate.dto.CandidateResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

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
    public ResponseEntity<CandidateResponseDto> createCandidate(@RequestBody Candidate candidate) {
        candidate.setCreatedAt(LocalDateTime.now());
        Candidate saved = candidateRepository.save(candidate);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CandidateResponseDto(saved));
    }
}
