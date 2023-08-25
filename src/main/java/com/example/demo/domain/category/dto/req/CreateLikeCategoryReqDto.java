package com.example.demo.domain.category.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLikeCategoryReqDto {

    @Schema(description = "카테고리 이름 리스트")
    private List<String> category;

}
