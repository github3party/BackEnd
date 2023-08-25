package com.example.demo.domain.user;

import com.example.demo.domain.user.dto.params.KakaoLoginParams;
import com.example.demo.domain.user.jwt.AuthTokens;
import com.example.demo.domain.user.jwt.AuthTokensGenerator;
import com.example.demo.domain.user.service.OAuthLoginService;
import com.example.demo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "user api ")
public class UserController {

    private final OAuthLoginService oAuthLoginService;
    private final AuthTokensGenerator authTokensGenerator;

    @PostMapping("/kakao/accessToken")
    @Operation(summary = "access Token 으로 카카오 로그인", description = "로그인 시에 Access Token이 필요합니다.")
    public ApplicationResponse<AuthTokens> loginKakao() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String accessToken = request.getHeader("X-ACCESS-TOKEN");
        return ApplicationResponse.ok(oAuthLoginService.testLogin(accessToken));
    }

    @PostMapping("/kakao/authorization")
    @Operation(summary = "authorizationCode 으로 카카오 로그인", description = "로그인 시에 authorizationCode가 필요합니다.")
    public ApplicationResponse<AuthTokens> loginKakao(@RequestBody KakaoLoginParams params) {
        return ApplicationResponse.ok(oAuthLoginService.login(params));
    }

    @GetMapping("")
    @Operation(summary = "유저 정보", description = "유저 정보 API 입니다.")
    public ApplicationResponse<?> geMember(){
        Long memberId = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(memberId);
    }

}
