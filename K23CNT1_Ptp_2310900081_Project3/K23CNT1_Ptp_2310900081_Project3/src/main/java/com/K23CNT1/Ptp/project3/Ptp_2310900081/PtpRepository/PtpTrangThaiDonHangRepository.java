package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpTrangThaiDonHang;
import org.springframework.data.jpa.repository.JpaRepository; // <-- Quan trọng: Import thư viện JPA
import org.springframework.stereotype.Repository;

@Repository
// QUAN TRỌNG: Phải có 'extends JpaRepository<Entity, ID>' để có hàm findAll()
public interface PtpTrangThaiDonHangRepository extends JpaRepository<PtpTrangThaiDonHang, Long> {

    // Bạn có thể thêm các phương thức tìm kiếm tùy chỉnh ở đây nếu cần
    // Ví dụ: Optional<PtpTrangThaiDonHang> findByTenTrangThai(String ten);
}