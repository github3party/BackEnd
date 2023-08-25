package com.example.demo.domain;

import com.example.demo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/test")
@Tag(name = "Test Controller", description = "test api ")
public class TestController {

    @GetMapping
    @Operation(summary = "테스트 API 입니다.", description = "로그인 시에 Access Token이 필요합니다.")
    public ApplicationResponse<?> test(){
        return ApplicationResponse.ok("테스트 API 입니다.");
    }
}
