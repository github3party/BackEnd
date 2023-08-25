package com.example.demo.domain.etc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadSupporterResDto {
    @Schema(description = "후원자 수", defaultValue = "10")
    private long supporterSum;
}
