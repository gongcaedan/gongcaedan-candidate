package com.example.gongcaedan_candidate.controller;

import com.example.gongcaedan_candidate.entity.Party;
import com.example.gongcaedan_candidate.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parties")
@RequiredArgsConstructor
public class PartyController {

    private final PartyRepository partyRepository;

    // 전체 정당 조회
    @GetMapping
    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    // 정당 등록
    @PostMapping
    public Party createParty(@RequestBody Party party) {
        return partyRepository.save(party);
    }
}
