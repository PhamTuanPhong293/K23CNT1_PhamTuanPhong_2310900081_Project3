package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class PtpGlobalController {

    // Hàm này sẽ tự động chạy trước mọi Controller
    // Nó lấy đường dẫn hiện tại (URL) và gửi sang file HTML với tên biến là "currentUri"
    @ModelAttribute("currentUri")
    public String getCurrentUri(HttpServletRequest request) {
        return request.getRequestURI();
    }
}