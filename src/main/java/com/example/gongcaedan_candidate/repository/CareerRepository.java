package com.example.gongcaedan_candidate.repository;

import com.example.gongcaedan_candidate.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerRepository extends JpaRepository<Career, Long> {
    List<Career> findByCandidateId(Long candidateId);
}
