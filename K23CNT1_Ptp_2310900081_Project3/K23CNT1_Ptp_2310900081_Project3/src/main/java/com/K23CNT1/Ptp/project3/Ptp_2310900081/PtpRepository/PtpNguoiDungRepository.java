package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository; // Đảm bảo đúng package Repository

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpNguoiDung; // Import Entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; // Cần dùng cho tìm kiếm

@Repository
public interface PtpNguoiDungRepository extends JpaRepository<PtpNguoiDung, Long> {

    // Phương thức tìm kiếm tùy chỉnh cần thiết cho Spring Security
    // Spring Data JPA sẽ tự động tạo truy vấn SQL dựa trên tên phương thức:
    // SELECT * FROM PtpNguoiDung WHERE PtpTenDangNhap = ?
    Optional<PtpNguoiDung> findByTenDangNhap(String tenDangNhap);
} 