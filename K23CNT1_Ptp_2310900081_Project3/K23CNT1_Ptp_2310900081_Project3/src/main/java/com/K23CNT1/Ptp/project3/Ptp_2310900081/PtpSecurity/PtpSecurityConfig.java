package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpSecurity;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpNguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class PtpSecurityConfig {

    @Autowired
    private PtpNguoiDungService nguoiDungService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(nguoiDungService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // 1. Cho phép truy cập tự do vào các file tĩnh (css, js, ảnh) và trang login
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/login", "/register").permitAll()
                        // 2. Chỉ ADMIN mới vào được trang quản trị
                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                        // 3. Các trang còn lại phải đăng nhập mới xem được
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login") // Đường dẫn tới trang giao diện đăng nhập
                        .loginProcessingUrl("/login") // Link submit form (Spring tự xử lý)
                        .defaultSuccessUrl("/admin/sanpham", true) // Đăng nhập thành công thì về đây
                        .failureUrl("/login?error=true") // Sai mật khẩu thì về đây
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                );

        return http.build();
    }
}