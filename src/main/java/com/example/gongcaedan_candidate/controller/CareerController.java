package com.example.gongcaedan_candidate.controller;

import com.example.gongcaedan_candidate.dto.CareerRequestDto;
import com.example.gongcaedan_candidate.dto.CareerResponseDto;
import com.example.gongcaedan_candidate.service.CareerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CareerController {

    private final CareerService careerService;

    @GetMapping("/{id}/careers")
    public ResponseEntity<List<CareerResponseDto>> getCareers(@PathVariable Long id) {
        return ResponseEntity.ok(careerService.getCareers(id));
    }

    @PostMapping("/{id}/careers")
    public ResponseEntity<CareerResponseDto> createCareer(
            @PathVariable Long id,
            @RequestBody CareerRequestDto dto) {
        return ResponseEntity.ok(careerService.createCareer(id, dto));
    }
}
