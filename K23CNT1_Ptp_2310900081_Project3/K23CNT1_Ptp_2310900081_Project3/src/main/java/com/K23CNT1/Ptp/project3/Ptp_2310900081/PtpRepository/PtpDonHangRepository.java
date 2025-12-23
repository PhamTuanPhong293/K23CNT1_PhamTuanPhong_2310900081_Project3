package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PtpDonHangRepository extends JpaRepository<PtpDonHang, Long> {

    // Tìm kiếm đơn hàng theo người dùng (dùng cho khu vực cá nhân của khách hàng)
    List<PtpDonHang> findByNguoiDungIdOrderByNgayDatHangDesc(Long nguoiDungId);
}

// Lưu ý: Cần tạo PtpChiTietDonHangRepository và PtpTrangThaiDonHangRepository tương tự.