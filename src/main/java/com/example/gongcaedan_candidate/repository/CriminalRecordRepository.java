package com.example.gongcaedan_candidate.repository;

import com.example.gongcaedan_candidate.entity.CriminalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriminalRecordRepository extends JpaRepository<CriminalRecord, Long> {
    List<CriminalRecord> findByCandidateId(Long candidateId);
}
