package com.example.gongcaedan_candidate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", foreignKey = @ForeignKey(name = "fk_education_candidate"))
    private Candidate candidate;

    private String schoolName;
    private String major;
    private String degree; // 예: 학사, 석사, 박사
    private Integer graduationYear;
}
