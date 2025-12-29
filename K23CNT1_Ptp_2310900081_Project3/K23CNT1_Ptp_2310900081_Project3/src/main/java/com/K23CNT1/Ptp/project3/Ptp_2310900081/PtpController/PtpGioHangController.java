package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpController;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpGioHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/gio-hang")
public class PtpGioHangController {

    @Autowired
    private PtpGioHangService gioHangService;

    // Xem giỏ hàng
    @GetMapping("")
    public String xemGioHang(HttpSession session, Model model) {
        model.addAttribute("cartItems", gioHangService.getGioHang(session));
        model.addAttribute("tongTien", gioHangService.getTongTien(session));
        return "client/giohang";
    }

    // Thêm vào giỏ
    @GetMapping("/them/{id}")
    public String themVaoGio(@PathVariable Long id, HttpSession session) {
        gioHangService.themVaoGio(id, session);
        return "redirect:/gio-hang"; // Thêm xong chuyển hướng ngay đến trang giỏ hàng
    }

    // Xóa khỏi giỏ
    @GetMapping("/xoa/{id}")
    public String xoaKhoiGio(@PathVariable Long id, HttpSession session) {
        gioHangService.xoaKhoiGio(id, session);
        return "redirect:/gio-hang";
    }

    @GetMapping("/thanh-toan")
    public String thanhToan(HttpSession session, RedirectAttributes ra) {
        // 1. Xóa sạch giỏ hàng
        gioHangService.xoaHetGioHang(session);

        // 2. Tạo thông báo thành công (Flash Attribute giúp truyền tin nhắn sang trang sau)
        ra.addFlashAttribute("thongBao", "Thanh toán thành công! Cảm ơn bạn đã mua hàng.");

        // 3. Quay về trang giỏ hàng (lúc này đã trống)
        return "redirect:/gio-hang";
    }
}