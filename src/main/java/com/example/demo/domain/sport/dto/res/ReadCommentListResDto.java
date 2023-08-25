package com.example.demo.domain.sport.dto.res;

import com.example.demo.domain.category.entity.Category;
import com.example.demo.domain.sport.entity.Sport;
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
public class ReadCommentListResDto {

    @Schema(description = "스포츠 id", defaultValue = "1")
    private Long sportId;
    @Schema(description = "스포츠 이름", defaultValue = "카바디")
    private String sportName;

    private List<ReadCommentResDto> readCommentResDtos;

    public static ReadCommentListResDto of(Sport sport, List<ReadCommentResDto> readCommentResDtos){
        return ReadCommentListResDto.builder()
                .sportId(sport.getSportId())
                .sportName(sport.getSport())
                .readCommentResDtos(readCommentResDtos)
                .build();
    }
}
