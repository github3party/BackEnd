package com.example.demo.domain.category;

import com.example.demo.domain.category.dto.req.CreateLikeCategoryReqDto;
import com.example.demo.domain.category.dto.res.LikeCategoryResDto;
import com.example.demo.domain.user.jwt.AuthTokensGenerator;
import com.example.demo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/cateory")
@RequiredArgsConstructor
@Tag(name = "category Controller", description = "category api ")
public class CategoryController {

    private final AuthTokensGenerator authTokensGenerator;
    private final CategoryService categoryService;

    @PostMapping("")
    @Operation(summary = "나의 관심있는 종목 선택", description = "관심있는 종목 선택하기")
    public ApplicationResponse<List<LikeCategoryResDto>> createUserLike(@RequestBody CreateLikeCategoryReqDto createLikeCategoryReqDto ) {
        Long userId = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(categoryService.createUserLike(userId, createLikeCategoryReqDto));
    }

}
