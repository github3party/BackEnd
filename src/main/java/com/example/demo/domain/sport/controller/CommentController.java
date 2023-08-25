package com.example.demo.domain.sport.controller;

import com.example.demo.domain.sport.dto.req.CreateCommentReqDto;
import com.example.demo.domain.sport.dto.res.CreateCommentResDto;
import com.example.demo.domain.sport.dto.res.ReadCommentListResDto;
import com.example.demo.domain.sport.dto.res.ReadSportListResDto;
import com.example.demo.domain.sport.service.CommentService;
import com.example.demo.domain.user.jwt.AuthTokensGenerator;
import com.example.demo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/comment")
@RequiredArgsConstructor
@Tag(name = "comment Controller", description = "comment api ")
public class CommentController {

    private final AuthTokensGenerator authTokensGenerator;
    private final CommentService commentService;

    // 댓글 Crate
    @PostMapping("/")
    @Operation(summary = "댓글 생성", description = "댓글 생성")
    public ApplicationResponse<CreateCommentResDto> createComment(@RequestBody CreateCommentReqDto createCommentReqDto ) {
        Long userId = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(commentService.createComment(userId, createCommentReqDto));
    }

    // 댓글 Read
    @GetMapping("/{sportId}")
    @Operation(summary = "경기 댓글 보기", description = "경기 댓글 보기")
    public ApplicationResponse<ReadCommentListResDto> readCommentListBySport(@PathVariable Long sportId) {
        Long userId = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(commentService.readCommentListBySport(sportId));
    }


    // 댓글 Delete

    // 댓글 공감

    // 댓글 공감 취소

}
