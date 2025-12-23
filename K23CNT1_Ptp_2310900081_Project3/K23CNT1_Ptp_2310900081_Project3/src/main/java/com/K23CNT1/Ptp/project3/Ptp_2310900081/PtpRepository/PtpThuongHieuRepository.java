package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PtpThuongHieuRepository extends JpaRepository<PtpThuongHieu, Long> {
    // Không cần thêm phương thức tìm kiếm tùy chỉnh ở đây
}