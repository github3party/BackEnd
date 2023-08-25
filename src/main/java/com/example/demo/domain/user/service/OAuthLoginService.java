package com.example.demo.domain.user.service;

import com.example.demo.domain.user.client.OAuthApiClient;
import com.example.demo.domain.user.dto.OAuthInfoResponse;
import com.example.demo.domain.user.dto.params.OAuthLoginParams;
import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.jwt.AuthTokens;
import com.example.demo.domain.user.jwt.AuthTokensGenerator;
import com.example.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthLoginService {
    private final UserRepository userRepository;

    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    private final OAuthApiClient oAuthApiClient;
    /**
     * access Token 으로 카카오 로그인
     * */
    public AuthTokens testLogin(String accessToken){
        OAuthInfoResponse oAuthInfoResponse = oAuthApiClient.requestOauthInfo(accessToken);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    ///////////////////////////////////////////////////////////////////////
    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return userRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(User::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    /**
     * 유저가 없으면 새로 생성해주는
     * */
    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        User member = User.builder()
                .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return userRepository.save(member).getId();
    }

}
