package com.tt.talktok.configuration;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //AuthenticationManager Bean 등록
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        // 세션방식에서는 csrf 공격을 필수적으로 방어해야합니다.
        // jwt는 세션을 stateless 방식으로 진행하기 때문에 csrf를 disable로 처리
        //csrf disable
        http
                .csrf((auth) -> auth.disable());

        //From 로그인 방식 disable
        http
                .formLogin((auth) -> auth.disable());

        //http basic 인증 방식 disable
        http
                .httpBasic((auth) -> auth.disable());

        //경로별 인가 작업
        // 위는 모두 경로를 허용,
        // admin은 admin 권한을 가진 사람만 접근가능.
        // 다른 요청에 대해서는 로그인한 사람만 접근가능.
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/teacher/*", "/", "/student/*").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated());

       //cors 설정
        http.
                cors((cors)->cors
                        .configurationSource(new CorsConfigurationSource() {


                            @Override
                            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                                CorsConfiguration configuration = new CorsConfiguration();

                                // 프론트 에서 허용할 포트 지정
                                configuration.setAllowedOrigins(Collections.singletonList("http://localhost:80"));

                                // 허용할 메소드 방식
                                configuration.setAllowedMethods(Collections.singletonList("*"));

                                //  무조건 true로 진행
                                configuration.setAllowCredentials(true);

                                //허용할 header
                                configuration.setAllowedHeaders(Collections.singletonList("*"));
                                //허용할 시간
                                configuration.setMaxAge(3600L);
                                //허용할
                                configuration.setExposedHeaders(Collections.singletonList("Authorization"));

                                return configuration;
                            }
                        }));

        return http.build();
    }
}
