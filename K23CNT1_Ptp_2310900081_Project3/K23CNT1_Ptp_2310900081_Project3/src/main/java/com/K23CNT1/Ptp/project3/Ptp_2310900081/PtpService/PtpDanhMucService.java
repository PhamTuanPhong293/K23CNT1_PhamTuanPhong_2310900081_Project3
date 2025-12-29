package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpDanhMuc;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpDanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PtpDanhMucService {

    @Autowired
    private PtpDanhMucRepository danhMucRepository;

    // 1. Lấy tất cả danh mục (Dùng cho trang Danh sách & Dropdown)
    public List<PtpDanhMuc> layTatCaDanhMuc() {
        return danhMucRepository.findAll();
    }

    // 2. Lấy danh mục theo ID (Dùng cho chức năng Sửa)
    public Optional<PtpDanhMuc> layDanhMucTheoId(Long id) {
        return danhMucRepository.findById(id);
    }

    // 3. Lưu danh mục (Dùng cho Thêm mới & Cập nhật)
    public void luuDanhMuc(PtpDanhMuc danhMuc) {
        // Tự động tạo Slug nếu người dùng để trống
        // Ví dụ: Nhập "Giày Thể Thao" -> Slug thành "giay-the-thao"
        if (danhMuc.getSlug() == null || danhMuc.getSlug().trim().isEmpty()) {
            danhMuc.setSlug(danhMuc.getTenDanhMuc().toLowerCase().replace(" ", "-"));
        }
        danhMucRepository.save(danhMuc);
    }

    // 4. Xóa danh mục
    public void xoaDanhMuc(Long id) {
        danhMucRepository.deleteById(id);
    }
}