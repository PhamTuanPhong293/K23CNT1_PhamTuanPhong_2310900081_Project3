package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpController;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpNguoiDung;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpNguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/khachhang")
public class PtpAdminKhachHangController {

    @Autowired
    private PtpNguoiDungService nguoiDungService;

    // 1. Xem danh sách
    @GetMapping("")
    public String listUser(Model model) {
        model.addAttribute("listNguoiDung", nguoiDungService.layTatCaNguoiDung());
        return "admin/khachhang/danhsach";
    }

    // 2. Form Thêm mới
    @GetMapping("/them-moi")
    public String formThem(Model model) {
        model.addAttribute("nguoiDung", new PtpNguoiDung());
        model.addAttribute("roles", PtpNguoiDung.UserRole.values()); // Lấy danh sách ENUM
        return "admin/khachhang/form";
    }

    // 3. Form Sửa
    @GetMapping("/sua/{id}")
    public String formSua(@PathVariable Long id, Model model) {
        PtpNguoiDung u = nguoiDungService.layNguoiDungTheoId(id);
        if (u != null) {
            model.addAttribute("nguoiDung", u);
            model.addAttribute("roles", PtpNguoiDung.UserRole.values());
            return "admin/khachhang/form";
        }
        return "redirect:/admin/khachhang";
    }

    // 4. Lưu (Sử dụng phiên bản nâng cấp có bắt lỗi trùng lặp)
    @PostMapping("/luu")
    public String saveUser(@ModelAttribute PtpNguoiDung nguoiDung, RedirectAttributes ra, Model model) {
        try {
            nguoiDungService.luuNguoiDung(nguoiDung);
            ra.addFlashAttribute("thongBao", "Lưu thông tin khách hàng thành công!");
            return "redirect:/admin/khachhang";
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            // Lỗi khi trùng unique key (Email hoặc Username)
            e.printStackTrace();

            // Gửi thông báo lỗi ra view
            model.addAttribute("loi", "Lỗi: Tên đăng nhập hoặc Email đã tồn tại!");

            // Giữ lại dữ liệu cũ để người dùng không phải nhập lại từ đầu
            model.addAttribute("nguoiDung", nguoiDung);
            model.addAttribute("roles", PtpNguoiDung.UserRole.values());

            // Trả về trang form (không redirect) để hiện lỗi
            return "admin/khachhang/form";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("loi", "Có lỗi xảy ra: " + e.getMessage());
            model.addAttribute("nguoiDung", nguoiDung);
            model.addAttribute("roles", PtpNguoiDung.UserRole.values());
            return "admin/khachhang/form";
        }
    }

    // 5. Xóa
    @GetMapping("/xoa/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes ra) {
        try {
            nguoiDungService.xoaNguoiDung(id);
            ra.addFlashAttribute("thongBao", "Đã xóa người dùng.");
        } catch (Exception e) {
            ra.addFlashAttribute("loi", "Không thể xóa (có thể do ràng buộc dữ liệu đơn hàng).");
        }
        return "redirect:/admin/khachhang";
    }
}