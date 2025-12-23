package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "PtpTrangThaiDonHang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtpTrangThaiDonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PtpId")
    private Long id;

    @Column(name = "PtpTenTrangThai", unique = true, nullable = false)
    private String tenTrangThai;

    @Column(name = "PtpMoTa")
    private String moTa;
}