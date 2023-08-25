package com.example.demo.domain.sport.dto.req;

import com.example.demo.domain.sport.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentReqDto {

    @Schema(description = "댓글")
    private Comment comment;
}
