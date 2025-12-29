package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpController;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpDonHang;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/donhang")
public class PtpAdminDonHangController {

    @Autowired
    private PtpDonHangService donHangService;

    // 1. Hiển thị danh sách đơn hàng
    @GetMapping("")
    public String listDonHang(Model model) {
        model.addAttribute("listDonHang", donHangService.layTatCaDonHang());
        return "admin/donhang/danhsach";
    }

    // 2. Hiển thị chi tiết đơn hàng (kèm Form cập nhật trạng thái)
    @GetMapping("/chitiet/{id}")
    public String chiTiet(@PathVariable Long id, Model model) {
        // Vì Service trả về Optional, ta dùng .orElse(null) để lấy giá trị thực
        PtpDonHang dh = donHangService.layDonHangTheoId(id).orElse(null);

        if (dh != null) {
            model.addAttribute("donHang", dh);
            // Lấy danh sách trạng thái để đổ vào Dropdown
            model.addAttribute("listTrangThai", donHangService.layTatCaTrangThai());
            return "admin/donhang/chitiet";
        }

        // Nếu không tìm thấy đơn hàng, quay về danh sách
        return "redirect:/admin/donhang";
    }

    // 3. Xử lý cập nhật trạng thái
    @PostMapping("/capnhat-trangthai")
    public String updateStatus(@RequestParam Long id, @RequestParam Long trangThaiId) {
        try {
            donHangService.capNhatTrangThaiDonHang(id, trangThaiId);
        } catch (IllegalArgumentException e) {
            // Có thể thêm xử lý lỗi ở đây nếu cần
            e.printStackTrace();
        }
        return "redirect:/admin/donhang/chitiet/" + id;
    }
}