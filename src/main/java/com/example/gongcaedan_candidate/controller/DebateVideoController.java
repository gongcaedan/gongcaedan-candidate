package com.example.gongcaedan_candidate.controller;

import com.example.gongcaedan_candidate.dto.DebateVideoRequestDto;
import com.example.gongcaedan_candidate.dto.DebateVideoResponseDto;
import com.example.gongcaedan_candidate.service.DebateVideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class DebateVideoController {

    private final DebateVideoService debateVideoService;

    @GetMapping("/{id}/debate-videos")
    public ResponseEntity<List<DebateVideoResponseDto>> getDebateVideos(@PathVariable Long id) {
        return ResponseEntity.ok(debateVideoService.getDebateVideos(id));
    }

    @PostMapping("/{id}/debate-videos")
    public ResponseEntity<DebateVideoResponseDto> createDebateVideo(
            @PathVariable Long id,
            @RequestBody DebateVideoRequestDto dto) {
        return ResponseEntity.ok(debateVideoService.createDebateVideo(id, dto));
    }
}
