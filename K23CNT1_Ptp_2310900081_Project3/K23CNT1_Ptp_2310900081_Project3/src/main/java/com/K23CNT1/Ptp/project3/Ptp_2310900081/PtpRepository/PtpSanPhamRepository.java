package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PtpSanPhamRepository extends JpaRepository<PtpSanPham, Long> {

    // Tìm kiếm sản phẩm theo Slug (dùng cho trang chi tiết sản phẩm)
    Optional<PtpSanPham> findBySlug(String slug);

    // Tìm kiếm sản phẩm theo ID danh mục (Dùng cho trang danh sách sản phẩm)
    List<PtpSanPham> findByDanhMucId(Long danhMucId);

    // Tìm kiếm sản phẩm theo tên (dùng cho chức năng tìm kiếm)
    List<PtpSanPham> findByTenSanPhamContaining(String keyword);
}
// Lưu ý: Repository cho PtpDanhMuc và PtpThuongHieu cũng được tạo tương tự