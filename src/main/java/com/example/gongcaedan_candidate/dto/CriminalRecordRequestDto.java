package com.example.gongcaedan_candidate.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CriminalRecordRequestDto {
    private String caseDetail;
    private String sentence;
    private LocalDate judgmentDate;
}
