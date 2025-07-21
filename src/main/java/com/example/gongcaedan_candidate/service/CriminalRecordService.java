package com.example.gongcaedan_candidate.service;

import com.example.gongcaedan_candidate.dto.CriminalRecordRequestDto;
import com.example.gongcaedan_candidate.dto.CriminalRecordResponseDto;
import com.example.gongcaedan_candidate.entity.Candidate;
import com.example.gongcaedan_candidate.entity.CriminalRecord;
import com.example.gongcaedan_candidate.repository.CandidateRepository;
import com.example.gongcaedan_candidate.repository.CriminalRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CriminalRecordService {

    private final CandidateRepository candidateRepository;
    private final CriminalRecordRepository criminalRecordRepository;

    public List<CriminalRecordResponseDto> getCriminalRecordsByCandidateId(Long candidateId) {
        return criminalRecordRepository.findByCandidateId(candidateId)
                .stream()
                .map(c -> CriminalRecordResponseDto.builder()
                        .id(c.getId())
                        .caseDetail(c.getCaseDetail())
                        .sentence(c.getSentence())
                        .judgmentDate(c.getJudgmentDate())
                        .build())
                .collect(Collectors.toList());
    }

    public CriminalRecordResponseDto createCriminalRecord(Long candidateId, CriminalRecordRequestDto dto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new IllegalArgumentException("후보자가 존재하지 않습니다."));

        CriminalRecord saved = criminalRecordRepository.save(
                CriminalRecord.builder()
                        .candidate(candidate)
                        .caseDetail(dto.getCaseDetail())
                        .sentence(dto.getSentence())
                        .judgmentDate(dto.getJudgmentDate())
                        .build()
        );

        return CriminalRecordResponseDto.builder()
                .id(saved.getId())
                .caseDetail(saved.getCaseDetail())
                .sentence(saved.getSentence())
                .judgmentDate(saved.getJudgmentDate())
                .build();
    }
}
