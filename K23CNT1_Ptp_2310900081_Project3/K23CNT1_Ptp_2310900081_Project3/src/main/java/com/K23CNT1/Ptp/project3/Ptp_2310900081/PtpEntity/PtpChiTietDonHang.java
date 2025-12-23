package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "PtpChiTietDonHang")
@Data
@NoArgsConstructor
public class PtpChiTietDonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PtpId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PtpDonHangId", nullable = false)
    private PtpDonHang donHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PtpSanPhamId", nullable = false)
    private PtpSanPham sanPham;

    @Column(name = "PtpSoLuong", nullable = false)
    private Integer soLuong;

    @Column(name = "PtpGiaTaiThoiDiemMua", nullable = false, precision = 10, scale = 2)
    private BigDecimal giaTaiThoiDiemMua; // Lưu giá cố định tại thời điểm mua
}