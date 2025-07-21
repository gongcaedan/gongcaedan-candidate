package com.example.gongcaedan_candidate.service;

import com.example.gongcaedan_candidate.dto.DebateVideoRequestDto;
import com.example.gongcaedan_candidate.dto.DebateVideoResponseDto;
import com.example.gongcaedan_candidate.entity.Candidate;
import com.example.gongcaedan_candidate.entity.DebateVideo;
import com.example.gongcaedan_candidate.repository.CandidateRepository;
import com.example.gongcaedan_candidate.repository.DebateVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DebateVideoService {

    private final DebateVideoRepository debateVideoRepository;
    private final CandidateRepository candidateRepository;

    public List<DebateVideoResponseDto> getDebateVideos(Long candidateId) {
        return debateVideoRepository.findByCandidateId(candidateId)
                .stream()
                .map(v -> DebateVideoResponseDto.builder()
                        .id(v.getId())
                        .title(v.getTitle())
                        .videoUrl(v.getVideoUrl())
                        .broadcastDate(v.getBroadcastDate())
                        .build())
                .collect(Collectors.toList());
    }

    public DebateVideoResponseDto createDebateVideo(Long candidateId, DebateVideoRequestDto dto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new IllegalArgumentException("해당 후보자가 존재하지 않습니다."));

        DebateVideo saved = debateVideoRepository.save(
                DebateVideo.builder()
                        .candidate(candidate)
                        .title(dto.getTitle())
                        .videoUrl(dto.getVideoUrl())
                        .broadcastDate(dto.getBroadcastDate())
                        .build()
        );

        return DebateVideoResponseDto.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .videoUrl(saved.getVideoUrl())
                .broadcastDate(saved.getBroadcastDate())
                .build();
    }
}
