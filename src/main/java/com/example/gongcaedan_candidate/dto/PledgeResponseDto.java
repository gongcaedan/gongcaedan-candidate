package com.example.gongcaedan_candidate.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PledgeResponseDto {
    private Long id;
    private String title;
    private String description;
    private String category;
    private LocalDateTime createdAt;
}
