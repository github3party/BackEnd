package com.example.demo.domain.category.dto.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeCategoryResDto {
    @Schema(description = "카테고리 id", defaultValue = "1")
    private Long categoryId;
    @Schema(description = "카테고리 이름", defaultValue = "구기")
    private String type;
    @Schema(description = "관심있는 카테고리 id", defaultValue = "1")
    private Long likeCategoryId;
}
