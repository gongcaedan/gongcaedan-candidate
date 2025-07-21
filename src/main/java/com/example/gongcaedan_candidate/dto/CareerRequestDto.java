package com.example.gongcaedan_candidate.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CareerRequestDto {
    private String position;
    private String organization;
    private LocalDate startDate;
    private LocalDate endDate;
}
