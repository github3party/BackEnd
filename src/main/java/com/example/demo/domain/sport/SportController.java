package com.example.demo.domain.sport;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/sport")
@RequiredArgsConstructor
@Tag(name = "sport Controller", description = "sport api ")
public class SportController {

}
