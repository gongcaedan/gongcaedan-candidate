package com.example.gongcaedan_candidate.repository;

import com.example.gongcaedan_candidate.entity.Pledge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PledgeRepository extends JpaRepository<Pledge, Long> {
    List<Pledge> findByCandidateId(Long candidateId);
}
