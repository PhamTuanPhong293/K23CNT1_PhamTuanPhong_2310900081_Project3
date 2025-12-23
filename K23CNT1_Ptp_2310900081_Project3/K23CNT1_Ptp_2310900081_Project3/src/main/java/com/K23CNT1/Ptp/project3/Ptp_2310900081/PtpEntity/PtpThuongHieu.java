package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "PtpThuongHieu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtpThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PtpId")
    private Long id;

    @Column(name = "PtpTenThuongHieu", unique = true, nullable = false)
    private String tenThuongHieu;

    @Column(name = "PtpSlug", unique = true, nullable = false)
    private String slug;
}
