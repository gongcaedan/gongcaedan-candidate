package com.example.gongcaedan_candidate.controller;

import com.example.gongcaedan_candidate.dto.CriminalRecordRequestDto;
import com.example.gongcaedan_candidate.dto.CriminalRecordResponseDto;
import com.example.gongcaedan_candidate.service.CriminalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CriminalRecordController {

    private final CriminalRecordService criminalRecordService;

    @GetMapping("/{id}/criminal-records")
    public ResponseEntity<List<CriminalRecordResponseDto>> getCriminalRecords(@PathVariable Long id) {
        return ResponseEntity.ok(criminalRecordService.getCriminalRecordsByCandidateId(id));
    }

    @PostMapping("/{id}/criminal-records")
    public ResponseEntity<CriminalRecordResponseDto> createCriminalRecord(
            @PathVariable Long id,
            @RequestBody CriminalRecordRequestDto dto) {
        return ResponseEntity.ok(criminalRecordService.createCriminalRecord(id, dto));
    }
}
