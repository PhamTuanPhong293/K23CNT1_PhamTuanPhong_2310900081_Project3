package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpSecurity;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpNguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class PtpSecurityConfig {

    @Autowired
    private PtpNguoiDungService nguoiDungService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 👇 1. TIÊM (INJECT) HANDLER VỪA TẠO VÀO ĐÂY
    @Autowired
    private PtpLoginSuccessHandler loginSuccessHandler;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(nguoiDungService);
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/login", "/register", "/gio-hang/**").permitAll()
                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login")

                        // 👇 2. THAY THẾ defaultSuccessUrl BẰNG successHandler
                        // .defaultSuccessUrl("/admin/sanpham", true) <--- XÓA HOẶC COMMENT DÒNG NÀY
                        .successHandler(loginSuccessHandler) // <--- THÊM DÒNG NÀY

                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                );

        return http.build();
    }
}