package com.example.gongcaedan_candidate.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Pledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String description;

    private String category;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "candidate_id",
            foreignKey = @ForeignKey(name = "fk_pledge_candidate")
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Candidate candidate;
}
