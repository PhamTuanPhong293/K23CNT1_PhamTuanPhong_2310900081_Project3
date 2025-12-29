package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpController;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpSanPham;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class PtpHomeController {

    @Autowired
    private PtpSanPhamService sanPhamService;

    // Trang chủ: Hiển thị toàn bộ sản phẩm
    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("listSanPham", sanPhamService.layTatCaSanPham());
        return "client/index";
    }

    // 👇 HÀM MỚI THÊM: Xem chi tiết sản phẩm
    @GetMapping("/san-pham/{id}")
    public String xemChiTiet(@PathVariable Long id, Model model) {
        Optional<PtpSanPham> sp = sanPhamService.laySanPhamTheoId(id);

        if (sp.isPresent()) {
            model.addAttribute("sanPham", sp.get());
            return "client/chitiet"; // Trỏ đến file templates/client/chitiet.html
        } else {
            return "redirect:/"; // Nếu không tìm thấy ID thì quay về trang chủ
        }
    }
}