package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PtpDonHang")
@Data
@NoArgsConstructor
public class PtpDonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PtpId")
    private Long id;

    @Column(name = "PtpNgayDatHang", nullable = false)
    private LocalDateTime ngayDatHang = LocalDateTime.now();

    @Column(name = "PtpTongTien", nullable = false, precision = 10, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "PtpDiaChiGiaoHang", columnDefinition = "TEXT")
    private String diaChiGiaoHang;

    // Mối quan hệ với Người dùng
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PtpNguoiDungId")
    private PtpNguoiDung nguoiDung; // Nullable nếu khách hàng đặt hàng không đăng nhập

    // Mối quan hệ với Trạng thái đơn hàng
    @ManyToOne(fetch = FetchType.EAGER) // Eager vì trạng thái rất quan trọng
    @JoinColumn(name = "PtpTrangThaiDonHangId", nullable = false)
    private PtpTrangThaiDonHang trangThai;

    // Mối quan hệ One-to-Many với Chi Tiết Đơn Hàng
    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.Set<PtpChiTietDonHang> chiTietDonHang;
}