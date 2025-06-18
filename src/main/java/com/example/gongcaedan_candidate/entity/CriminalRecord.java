package com.example.gongcaedan_candidate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CriminalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", foreignKey = @ForeignKey(name = "fk_criminal_candidate"))
    private Candidate candidate;

    @Lob
    private String caseDetail;

    private String sentence;

    private LocalDate judgmentDate;
}
