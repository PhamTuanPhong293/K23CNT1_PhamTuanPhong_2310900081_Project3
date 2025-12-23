package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor; // <-- 1. Bổ sung cái này
import java.math.BigDecimal;

@Entity
@Table(name = "PtpSanPham")
@Data
@NoArgsConstructor
@AllArgsConstructor // <-- 2. Bắt buộc có để dùng constructor trong Data Seeding
public class PtpSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PtpId")
    private Long id;

    @Column(name = "PtpTenSanPham", nullable = false)
    private String tenSanPham;

    @Column(name = "PtpGiaBan", nullable = false, precision = 10, scale = 2)
    private BigDecimal giaBan;

    @Column(name = "PtpMoTa", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "PtpAnhChinhUrl")
    private String anhChinhUrl;

    @Column(name = "PtpSlug", unique = true)
    private String slug;

    // --- SỬA LẠI FETCH TYPE ---
    // Nên để mặc định (EAGER) hoặc bỏ fetch đi để tránh lỗi "LazyInitializationException" bên View
    @ManyToOne
    @JoinColumn(name = "PtpDanhMucId", nullable = false)
    private PtpDanhMuc danhMuc;

    @ManyToOne
    @JoinColumn(name = "PtpThuongHieuId", nullable = false)
    private PtpThuongHieu thuongHieu;

    @Column(name = "PtpTrangThaiHoatDong")
    private Boolean trangThaiHoatDong = true;
}