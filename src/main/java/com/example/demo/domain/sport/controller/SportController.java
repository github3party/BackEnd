package com.example.demo.domain.sport.controller;

import com.example.demo.domain.sport.SportService;
import com.example.demo.domain.sport.dto.res.ReadSportListResDto;
import com.example.demo.domain.sport.entity.Sport;
import com.example.demo.domain.user.jwt.AuthTokensGenerator;
import com.example.demo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/sport")
@RequiredArgsConstructor
@Tag(name = "sport Controller", description = "sport api ")
public class SportController {

    private final AuthTokensGenerator authTokensGenerator;
    private final SportService sportService;

    // 카테고리별 스포츠 목록보기
    @GetMapping("/{categoryId}")
    @Operation(summary = "카테고리별 스포츠 목록보기", description = "카테고리별 스포츠 목록보기")
    public ApplicationResponse<ReadSportListResDto> readSportListByCategory(@PathVariable Long categoryId) {
        Long userId = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(sportService.readSportListByCategory(userId, categoryId));
    }

    // 스포츠 하나보기

    // 스포츠 등록

}
