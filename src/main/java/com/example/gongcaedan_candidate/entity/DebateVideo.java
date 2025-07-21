package com.example.gongcaedan_candidate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DebateVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String videoUrl;

    private LocalDate broadcastDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", foreignKey = @ForeignKey(name = "fk_debate_video_candidate"))
    private Candidate candidate;
}
