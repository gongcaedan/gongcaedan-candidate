package com.example.gongcaedan_candidate.controller;

import com.example.gongcaedan_candidate.dto.EducationRequestDto;
import com.example.gongcaedan_candidate.dto.EducationResponseDto;
import com.example.gongcaedan_candidate.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @GetMapping("/{id}/educations")
    public ResponseEntity<List<EducationResponseDto>> getEducations(@PathVariable Long id) {
        return ResponseEntity.ok(educationService.getEducations(id));
    }

    @PostMapping("/{id}/educations")
    public ResponseEntity<EducationResponseDto> createEducation(
            @PathVariable Long id,
            @RequestBody EducationRequestDto dto) {
        return ResponseEntity.ok(educationService.createEducation(id, dto));
    }
}
