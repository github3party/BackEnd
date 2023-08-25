package com.example.demo.domain.user.service;

import com.example.demo.domain.user.client.OAuthApiClient;
import com.example.demo.domain.user.dto.OAuthInfoResponse;
import com.example.demo.domain.user.dto.params.OAuthLoginParams;
import com.example.demo.domain.user.entity.OAuthProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RequestOAuthInfoService {
    /**
     * 지금까지 만든 OAuthApiClient 를 사용하는 Service 클래스입니다.
     *
     * KakaoApiClient, NaverApiClient 를 직접 주입받아서 사용하면 중복되는 코드가 많아지지만 List<OAuthApiClient> 를 주입 받아서 Map 으로 만들어두면 간단하게 사용할 수 있습니다.
     *
     * 참고로 List<인터페이스> 를 주입받으면 해당 인터페이스의 구현체들이 전부 List 에 담겨옵니다.
     * */
    private final Map<OAuthProvider, OAuthApiClient> clients;

    public RequestOAuthInfoService(List<OAuthApiClient> clients) {
        this.clients = clients.stream().collect(
                Collectors.toUnmodifiableMap(OAuthApiClient::oAuthProvider, Function.identity())
        );
    }

    public OAuthInfoResponse request(OAuthLoginParams params) {
        OAuthApiClient client = clients.get(params.oAuthProvider());
        String accessToken = client.requestAccessToken(params);

        return client.requestOauthInfo(accessToken);
    }


}