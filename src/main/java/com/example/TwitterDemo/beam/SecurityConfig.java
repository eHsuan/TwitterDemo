package com.example.TwitterDemo.beam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 允許 H2 Console 的 CSRF
                .csrf(csrf -> csrf.disable())
                // 允許 H2 Console 在 iframe 中顯示
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                // 設定 API 的授權
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 所有 API 都開放
                );
        return http.build();
    }
}
