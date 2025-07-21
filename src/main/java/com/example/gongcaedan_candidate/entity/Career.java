package com.example.gongcaedan_candidate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", foreignKey = @ForeignKey(name = "fk_career_candidate"))
    private Candidate candidate;

    private String position;
    private String organization;
    private LocalDate startDate;
    private LocalDate endDate;
}
