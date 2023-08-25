package com.example.demo.domain;

import com.example.demo.global.dto.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/test")
public class TestController {

    @GetMapping
    public ApplicationResponse<?> test(){
        return ApplicationResponse.ok("테스트 API 입니다.");
    }
}
