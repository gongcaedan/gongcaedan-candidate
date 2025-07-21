package com.example.gongcaedan_candidate.repository;

import com.example.gongcaedan_candidate.entity.DebateVideo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebateVideoRepository extends JpaRepository<DebateVideo, Long> {
    List<DebateVideo> findByCandidateId(Long candidateId);
}
