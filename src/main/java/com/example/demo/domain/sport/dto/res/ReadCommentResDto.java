package com.example.demo.domain.sport.dto.res;

import com.example.demo.domain.sport.dto.req.CreateCommentReqDto;
import com.example.demo.domain.sport.entity.Comment;
import com.example.demo.domain.sport.entity.Sport;
import com.example.demo.domain.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadCommentResDto {

    @Schema(description = "유저 id", defaultValue = "1")
    private Long userId;
    @Schema(description = "유저 이름", defaultValue = "이상민")
    private String userName;
    @Schema(description = "댓글", defaultValue = "화이팅")
    private String comment;
    @Schema(description = "댓글 좋아요 수", defaultValue = "1")
    private long likeCommentSum;

    public static ReadCommentResDto of(Comment comment){
        return ReadCommentResDto.builder()
                .userId(comment.getUser().getId())
                .userName(comment.getUser().getNickname())
                .comment(comment.getComment())
                .likeCommentSum(comment.getCommentList().size())
                .build();
    }
}
