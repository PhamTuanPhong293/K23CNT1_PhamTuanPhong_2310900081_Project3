package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Trả về file login.html (Thymeleaf)
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        // Chỉ người dùng có quyền ADMIN mới vào được đây
        return "admin/index";
    }
}