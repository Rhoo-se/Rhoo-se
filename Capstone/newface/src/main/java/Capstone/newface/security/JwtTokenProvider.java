package Capstone.newface.security; // 예시 패키지 경로

import io.jsonwebtoken.*; // jjwt 라이브러리 필요
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;


@Component // 스프링 빈으로 등록
public class JwtTokenProvider {

    @Value("${app.jwtSecret}") // application.properties 또는 yml에서 설정
    private String jwtSecret;

    @Value("${app.jwtExpirationMs}") // application.properties 또는 yml에서 설정 (밀리초)
    private int jwtExpirationMs;

    // JWT 서명을 위한 키 가져오기
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(jwtSecret));
    }

    // JWT 토큰 생성 메소드
    public String generateToken(String userMail) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(userMail) // 토큰의 주체 (여기서는 사용자 ID)
                .setIssuedAt(now) // 발행 시간
                .setExpiration(expiryDate) // 만료 시간
                .signWith(key(), SignatureAlgorithm.HS512) // 서명 알고리즘과 Secret Key
                .compact();
    }

}