package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpController;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpDanhMuc;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/danhmuc")
public class PtpAdminDanhMucController {

    @Autowired
    private PtpDanhMucService danhMucService;

    // 1. Hiển thị danh sách danh mục
    @GetMapping("")
    public String hienThiDanhSach(Model model) {
        model.addAttribute("listDanhMuc", danhMucService.layTatCaDanhMuc());
        return "admin/danhmuc/danhsach"; // Trả về file HTML danh sách
    }

    // 2. Hiển thị form Thêm mới
    @GetMapping("/them-moi")
    public String hienThiFormThem(Model model) {
        model.addAttribute("danhMuc", new PtpDanhMuc()); // Tạo object rỗng
        return "admin/danhmuc/form"; // Trả về file HTML form
    }

    // 3. Hiển thị form Sửa
    @GetMapping("/sua/{id}")
    public String hienThiFormSua(@PathVariable Long id, Model model) {
        PtpDanhMuc dm = danhMucService.layDanhMucTheoId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID danh mục không hợp lệ: " + id));

        model.addAttribute("danhMuc", dm); // Đổ dữ liệu cũ vào form
        return "admin/danhmuc/form";
    }

    // 4. Xử lý Lưu (Dùng chung cho cả Thêm và Sửa)
    @PostMapping("/luu")
    public String luuDanhMuc(@ModelAttribute PtpDanhMuc danhMuc, RedirectAttributes ra) {
        danhMucService.luuDanhMuc(danhMuc);
        ra.addFlashAttribute("thongBao", "Lưu danh mục thành công!");
        return "redirect:/admin/danhmuc"; // Quay về trang danh sách
    }

    // 5. Xử lý Xóa
    @GetMapping("/xoa/{id}")
    public String xoaDanhMuc(@PathVariable Long id, RedirectAttributes ra) {
        try {
            danhMucService.xoaDanhMuc(id);
            ra.addFlashAttribute("thongBao", "Xóa danh mục thành công!");
        } catch (Exception e) {
            // Trường hợp danh mục đang được sử dụng ở bảng Sản Phẩm
            ra.addFlashAttribute("loi", "Không thể xóa danh mục này vì đang có sản phẩm thuộc về nó.");
        }
        return "redirect:/admin/danhmuc";
    }
}