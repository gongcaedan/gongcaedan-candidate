package com.example.gongcaedan_candidate.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebateVideoResponseDto {
    private Long id;
    private String title;
    private String videoUrl;
    private LocalDate broadcastDate;
}
