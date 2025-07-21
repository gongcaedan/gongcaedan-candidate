package com.example.gongcaedan_candidate.repository;

import com.example.gongcaedan_candidate.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByCandidateId(Long candidateId);
}
