package com.example.gongcaedan_candidate.service;

import com.example.gongcaedan_candidate.dto.PledgeRequestDto;
import com.example.gongcaedan_candidate.dto.PledgeResponseDto;
import com.example.gongcaedan_candidate.entity.Candidate;
import com.example.gongcaedan_candidate.entity.Pledge;
import com.example.gongcaedan_candidate.repository.CandidateRepository;
import com.example.gongcaedan_candidate.repository.PledgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PledgeService {

    private final PledgeRepository pledgeRepository;
    private final CandidateRepository candidateRepository;

    public List<PledgeResponseDto> getPledgesByCandidateId(Long candidateId) {
        List<Pledge> pledges = pledgeRepository.findByCandidateId(candidateId);

        return pledges.stream()
                .map(p -> PledgeResponseDto.builder()
                        .id(p.getId())
                        .title(p.getTitle())
                        .description(p.getDescription())
                        .category(p.getCategory())
                        .createdAt(p.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    public PledgeResponseDto createPledge(Long candidateId, PledgeRequestDto dto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new IllegalArgumentException("해당 후보자가 존재하지 않습니다."));

        Pledge pledge = Pledge.builder()
                .candidate(candidate)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .createdAt(LocalDateTime.now())
                .build();

        Pledge saved = pledgeRepository.save(pledge);

        return PledgeResponseDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .description(saved.getDescription())
                .category(saved.getCategory())
                .createdAt(saved.getCreatedAt())
                .build();
    }
}
