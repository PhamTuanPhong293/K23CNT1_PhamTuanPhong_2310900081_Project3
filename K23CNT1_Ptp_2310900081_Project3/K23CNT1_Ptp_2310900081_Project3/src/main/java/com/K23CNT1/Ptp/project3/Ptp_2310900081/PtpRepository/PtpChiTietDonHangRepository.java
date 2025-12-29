package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PtpChiTietDonHangRepository extends JpaRepository<PtpChiTietDonHang, Long> {
    // Tìm các chi tiết thuộc về một đơn hàng cụ thể
    List<PtpChiTietDonHang> findByDonHangId(Long donHangId);
}