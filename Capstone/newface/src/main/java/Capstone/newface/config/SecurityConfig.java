package Capstone.newface.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // http 객체의 타입인 HttpSecurity 임포트
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer; // AbstractHttpConfigurer 임포트


@Configuration // 이 클래스가 스프링 설정 정보를 담고 있음을 나타냅니다.
@EnableWebSecurity
public class SecurityConfig {
    @Bean // 이 메소드가 반환하는 객체를 스프링 빈으로 등록합니다.
    public PasswordEncoder passwordEncoder() {
        // BCrypt 알고리즘을 사용하는 PasswordEncoder 구현체를 반환합니다.
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 보호 비활성화 (REST API에서는 일반적으로 비활성화)
                .csrf(AbstractHttpConfigurer::disable) // Spring Boot 3.1+ 문법

                // 요청 권한 설정
                .authorizeHttpRequests(authorize -> authorize
                        // /api/login 경로는 인증 없이 접근 허용 (임시 확인용!!)
                        .requestMatchers("/user/login").permitAll()
                        // 다른 모든 경로는 인증 필요
                        // .anyRequest().authenticated() // 모든 다른 요청은 인증 필요
                        .anyRequest().permitAll() // 임시로 모든 요청 허용 (테스트 편의)
                );
        // .formLogin(...) // 기본 폼 로그인 비활성화 (JWT 사용 시)
        // .httpBasic(...) // 기본 HTTP Basic 인증 비활성화 (JWT 사용 시)
        // .addFilterBefore(...) // JWT 인증 필터 추가 (나중에 구현)

        return http.build();
    }
}
