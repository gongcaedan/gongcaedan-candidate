package com.example.gongcaedan_candidate.repository;

import com.example.gongcaedan_candidate.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
