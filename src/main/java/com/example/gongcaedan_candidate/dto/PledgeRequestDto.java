package com.example.gongcaedan_candidate.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PledgeRequestDto {
    private String title;
    private String description;
    private String category;
}
