package com.example.demo.domain.etc;

import com.example.demo.domain.sport.dto.res.ReadSportResDto;
import com.example.demo.domain.etc.dto.ReadSupporterResDto;
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
@RequestMapping("/v1/etc")
@RequiredArgsConstructor
@Tag(name = "etc Controller", description = "etc api ")
public class EtcController {

    private final AuthTokensGenerator authTokensGenerator;
    private final EtcService etcService;

    @PostMapping("/search")
    @Operation(summary = "검색 하기", description = "X-ACCESS-TOKEN 필요")
    public ApplicationResponse<List<ReadSportResDto>> searchSport(@RequestBody String search) {
        Long userId = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(etcService.searchSport(userId, search));
    }

    @GetMapping("/supporter")
    @Operation(summary = "후원 클릭", description = "/v1/etc/supporter?sportId=  , X-ACCESS-TOKEN 필요")
    public ApplicationResponse<ReadSportResDto> createdSupporter(@RequestParam Long sportId) {
        Long userId = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(etcService.createdSupporter(userId, sportId));
    }

    @GetMapping("")
    @Operation(summary = "후원 인원 보기", description = "/v1/etc?sportId=  , X-ACCESS-TOKEN 필요")
    public ApplicationResponse<ReadSupporterResDto> readSupporter(@RequestParam Long sportId) {
        Long userId = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(etcService.readSupporter(userId, sportId));
    }

    @GetMapping("/alarm")
    @Operation(summary = "알람 클릭", description = "/v1/etc/alarm?sportId=  , X-ACCESS-TOKEN 필요")
    public ApplicationResponse<ReadSportResDto> createAlarm(@RequestParam Long sportId) {
        Long userId = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(etcService.createAlarm(userId, sportId));
    }


}
