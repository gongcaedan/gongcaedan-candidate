package com.example.gongcaedan_candidate.controller;

import com.example.gongcaedan_candidate.dto.PledgeResponseDto;
import com.example.gongcaedan_candidate.dto.PledgeRequestDto;
import com.example.gongcaedan_candidate.service.PledgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class PledgeController {

    private final PledgeService pledgeService;

    @GetMapping("/{id}/pledges")
    public ResponseEntity<List<PledgeResponseDto>> getPledgesByCandidate(@PathVariable("id") Long candidateId) {
        return ResponseEntity.ok(pledgeService.getPledgesByCandidateId(candidateId));
    }

    @PostMapping("/{id}/pledges")
    public ResponseEntity<PledgeResponseDto> createPledge(
            @PathVariable("id") Long candidateId,
            @RequestBody PledgeRequestDto pledgeRequestDto) {
        return ResponseEntity.ok(pledgeService.createPledge(candidateId, pledgeRequestDto));
    }

}



