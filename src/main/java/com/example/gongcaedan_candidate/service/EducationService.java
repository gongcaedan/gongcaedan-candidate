package com.example.gongcaedan_candidate.service;

import com.example.gongcaedan_candidate.dto.EducationRequestDto;
import com.example.gongcaedan_candidate.dto.EducationResponseDto;
import com.example.gongcaedan_candidate.entity.Candidate;
import com.example.gongcaedan_candidate.entity.Education;
import com.example.gongcaedan_candidate.repository.CandidateRepository;
import com.example.gongcaedan_candidate.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;
    private final CandidateRepository candidateRepository;

    public List<EducationResponseDto> getEducations(Long candidateId) {
        return educationRepository.findByCandidateId(candidateId)
                .stream()
                .map(e -> EducationResponseDto.builder()
                        .id(e.getId())
                        .schoolName(e.getSchoolName())
                        .major(e.getMajor())
                        .degree(e.getDegree())
                        .graduationYear(e.getGraduationYear())
                        .build())
                .collect(Collectors.toList());
    }

    public EducationResponseDto createEducation(Long candidateId, EducationRequestDto dto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new IllegalArgumentException("후보자가 존재하지 않습니다."));

        Education education = educationRepository.save(
                Education.builder()
                        .candidate(candidate)
                        .schoolName(dto.getSchoolName())
                        .major(dto.getMajor())
                        .degree(dto.getDegree())
                        .graduationYear(dto.getGraduationYear())
                        .build()
        );

        return EducationResponseDto.builder()
                .id(education.getId())
                .schoolName(education.getSchoolName())
                .major(education.getMajor())
                .degree(education.getDegree())
                .graduationYear(education.getGraduationYear())
                .build();
    }
}
