package com.example.gongcaedan_candidate.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationResponseDto {
    private Long id;
    private String schoolName;
    private String major;
    private String degree;
    private Integer graduationYear;
}
