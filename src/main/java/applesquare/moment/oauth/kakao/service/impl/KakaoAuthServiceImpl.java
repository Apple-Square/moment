package applesquare.moment.oauth.kakao.service.impl;

import applesquare.moment.oauth.kakao.dto.KakaoUserInfoReadResponseDTO;
import applesquare.moment.oauth.kakao.service.KakaoAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
@Transactional
@RequiredArgsConstructor
public class KakaoAuthServiceImpl implements KakaoAuthService {
    private final RestTemplate restTemplate;
    @Value("${kakao.api.key}")
    private String kakaoApiKey;
    @Value("${kakao.oauth.redirect-uri}")
    private String kakaoOauthRedirectUri;
    @Value("${kakao.token.url}")
    private String kakaoTokenUrl;
    @Value("${kakao.user.info.url}")
    private String kakaoUserInfoUrl;


    @Override
    public String getAccessToken(String code){
        // HTTP Header 생성
        HttpHeaders headers=new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");


        // HTTP Body 생성
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", kakaoApiKey);
        body.add("redirect_uri", kakaoOauthRedirectUri);
        body.add("code", code);

        // HTTP 요청 보내기
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest=new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.exchange(
                kakaoTokenUrl,
                HttpMethod.POST,
                kakaoTokenRequest,
                Map.class);

        // Id 토큰 추출
        Map<String, Object> responseBody = response.getBody();
        if(responseBody==null){
            throw new OAuth2AuthenticationException("Kakao 토큰 요청에 실패했습니다.");
        }

        String accessToken=(String) responseBody.get("access_token");
        if(accessToken==null){
            throw new OAuth2AuthenticationException("Kakao 토큰 응답에 access_token이 존재하지 않습니다.");
        }

        return accessToken;
    }

    @Override
    public KakaoUserInfoReadResponseDTO getUserInfo(String accessToken){
        // HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // HTTP 요청 보내기
        HttpEntity<String> kakaoUserRequest = new HttpEntity<>(headers);
        ResponseEntity<KakaoUserInfoReadResponseDTO> response = restTemplate.exchange(
                kakaoUserInfoUrl,
                HttpMethod.GET,
                kakaoUserRequest,
                KakaoUserInfoReadResponseDTO.class
        );

        return response.getBody();
    }
}
