package com.example.gongcaedan_candidate.dto;

import com.example.gongcaedan_candidate.entity.Candidate;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CandidateResponseDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private String profileImageUrl;
    private LocalDateTime createdAt;
    private String partyName;

    public CandidateResponseDto(Candidate candidate) {
        this.id = candidate.getId();
        this.name = candidate.getName();
        this.birthDate = candidate.getBirthDate();
        this.gender = candidate.getGender();
        this.profileImageUrl = candidate.getProfileImageUrl();
        this.createdAt = candidate.getCreatedAt();
        this.partyName = candidate.getParty() != null ? candidate.getParty().getName() : null;
    }
}
