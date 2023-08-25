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

import javax.swing.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCommentResDto {

    // 스포츠아이디
    // 스포츠이름
    // 유저 아이디
    // 유저이름
    // 댓글 공감수
    // 댓글


    @Schema(description = "스포츠 id", defaultValue = "1")
    private Long sportId;
    @Schema(description = "스포츠 이름", defaultValue = "카바디")
    private String sportName;
    @Schema(description = "유저 id", defaultValue = "1")
    private Long userId;
    @Schema(description = "유저 이름", defaultValue = "이상민")
    private String userName;
    @Schema(description = "댓글", defaultValue = "화이팅")
    private String comment;
    @Schema(description = "댓글 좋아요 수", defaultValue = "1")
    private long likeCommentSum;

    public static CreateCommentResDto of(User user, Sport sport, CreateCommentReqDto createCommentReqDto){
        return CreateCommentResDto.builder()
                .sportId(sport.getSportId())
                .sportName(sport.getSport())
                .userId(user.getId())
                .userName(user.getNickname())
                .comment(createCommentReqDto.getComment().getComment())
                .likeCommentSum(createCommentReqDto.getComment().getCommentList().size())
                .build();
    }
}
