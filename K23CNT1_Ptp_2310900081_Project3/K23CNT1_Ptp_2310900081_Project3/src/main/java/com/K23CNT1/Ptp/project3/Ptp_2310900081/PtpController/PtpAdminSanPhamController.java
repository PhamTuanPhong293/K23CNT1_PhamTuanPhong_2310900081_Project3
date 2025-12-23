package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpController;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpSanPham;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpSanPhamService;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpDanhMucService;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService.PtpThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/admin/sanpham")
public class PtpAdminSanPhamController {

    @Autowired
    private PtpSanPhamService sanPhamService;

    @Autowired
    private PtpDanhMucService danhMucService;

    @Autowired
    private PtpThuongHieuService thuongHieuService;

    // 1. Hiển thị danh sách (READ)
    @GetMapping("")
    public String hienThiDanhSach(Model model) {
        // SỬA: Dùng tên hàm 'layDanhSachSanPham' khớp với Service
        // SỬA: Dùng tên biến 'listSanPham' khớp với file danhsach.html
        model.addAttribute("listSanPham", sanPhamService.layDanhSachSanPham());
        return "admin/sanpham/danhsach";
    }

    // 2. Hiển thị form Thêm mới & Sửa (CREATE & UPDATE)
    // SỬA: Đổi '/them' thành '/them-moi' để khớp với nút bấm trong danhsach.html
    @GetMapping({"/them-moi", "/sua/{id}"})
    public String hienThiForm(@PathVariable(required = false) Long id, Model model) {

        // Đổ dữ liệu vào Dropdown
        model.addAttribute("listDanhMuc", danhMucService.layTatCaDanhMuc());
        model.addAttribute("listThuongHieu", thuongHieuService.layTatCaThuongHieu());

        // Logic phân biệt Thêm hay Sửa
        if (id != null) {
            // Trường hợp Sửa: Lấy dữ liệu cũ
            Optional<PtpSanPham> sp = sanPhamService.laySanPhamTheoId(id);
            if (sp.isPresent()) {
                model.addAttribute("sanPham", sp.get());
            } else {
                return "redirect:/admin/sanpham"; // ID không tồn tại thì quay về
            }
        } else {
            // Trường hợp Thêm mới: Tạo object rỗng
            model.addAttribute("sanPham", new PtpSanPham());
        }

        return "admin/sanpham/form";
    }

    // 3. Xử lý Lưu (SAVE)
    @PostMapping("/luu")
    public String luuSanPham(
            @ModelAttribute("sanPham") PtpSanPham sanPham,
            @RequestParam("anhFile") MultipartFile anhFile,
            RedirectAttributes ra) {

        // SỬA: Dùng tên hàm 'luuSanPham' khớp với Service mới nhất
        sanPhamService.luuSanPham(sanPham, anhFile);

        ra.addFlashAttribute("thongBao", "Thao tác thành công!");
        return "redirect:/admin/sanpham";
    }

    // 4. Xử lý Xóa (DELETE)
    @GetMapping("/xoa/{id}")
    public String xoaSanPham(@PathVariable Long id, RedirectAttributes ra) {
        sanPhamService.xoaSanPham(id);
        ra.addFlashAttribute("thongBao", "Xóa sản phẩm thành công!");
        return "redirect:/admin/sanpham";
    }
}