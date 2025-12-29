package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class PtpAdminController {

    @GetMapping("") // Khi vào /admin
    public String trangChuAdmin() {
        return "admin/index"; // Trả về file templates/admin/index.html
    }
}