package com.example.demo.domain.sport.dto.res;

import com.example.demo.domain.category.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadSportListResDto {

    @Schema(description = "카테고리 id", defaultValue = "1")
    private Long categoryId;
    @Schema(description = "카테고리 이름", defaultValue = "구기")
    private String type;

    private List<ReadSportResDto> readSportResDtos;

    public static ReadSportListResDto of(Category category, List<ReadSportResDto> readSportResDtos){
        return ReadSportListResDto.builder()
                .categoryId(category.getCategoryId())
                .type(category.getType())
                .readSportResDtos(readSportResDtos)
                .build();
    }
}
