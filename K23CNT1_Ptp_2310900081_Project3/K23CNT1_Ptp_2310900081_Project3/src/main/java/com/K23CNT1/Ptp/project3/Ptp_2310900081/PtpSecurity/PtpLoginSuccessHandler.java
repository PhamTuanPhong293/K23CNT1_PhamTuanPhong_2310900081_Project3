package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpSecurity;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

@Component
public class PtpLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // 1. Lấy danh sách quyền (Roles) của người vừa đăng nhập
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        // 2. Kiểm tra và điều hướng
        if (roles.contains("ADMIN")) {
            // Nếu là Admin -> Vào trang quản trị
            response.sendRedirect("/admin/sanpham");
        } else {
            // Nếu là User (hoặc quyền khác) -> Vào trang chủ Client
            response.sendRedirect("/");
        }
    }
}