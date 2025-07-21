package com.example.gongcaedan_candidate.service;

import com.example.gongcaedan_candidate.dto.CareerRequestDto;
import com.example.gongcaedan_candidate.dto.CareerResponseDto;
import com.example.gongcaedan_candidate.entity.Candidate;
import com.example.gongcaedan_candidate.entity.Career;
import com.example.gongcaedan_candidate.repository.CandidateRepository;
import com.example.gongcaedan_candidate.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CareerService {

    private final CareerRepository careerRepository;
    private final CandidateRepository candidateRepository;

    public List<CareerResponseDto> getCareers(Long candidateId) {
        return careerRepository.findByCandidateId(candidateId)
                .stream()
                .map(c -> CareerResponseDto.builder()
                        .id(c.getId())
                        .position(c.getPosition())
                        .organization(c.getOrganization())
                        .startDate(c.getStartDate())
                        .endDate(c.getEndDate())
                        .build())
                .collect(Collectors.toList());
    }

    public CareerResponseDto createCareer(Long candidateId, CareerRequestDto dto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new IllegalArgumentException("해당 후보자가 존재하지 않습니다."));

        Career career = careerRepository.save(
                Career.builder()
                        .candidate(candidate)
                        .position(dto.getPosition())
                        .organization(dto.getOrganization())
                        .startDate(dto.getStartDate())
                        .endDate(dto.getEndDate())
                        .build()
        );

        return CareerResponseDto.builder()
                .id(career.getId())
                .position(career.getPosition())
                .organization(career.getOrganization())
                .startDate(career.getStartDate())
                .endDate(career.getEndDate())
                .build();
    }
}
