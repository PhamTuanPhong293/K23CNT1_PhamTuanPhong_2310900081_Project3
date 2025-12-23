package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// Entity PtpDanhMuc
@Entity
@Table(name = "PtpDanhMuc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PtpDanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PtpId")
    private Long id;

    @Column(name = "PtpTenDanhMuc", unique = true, nullable = false)
    private String tenDanhMuc;

    @Column(name = "PtpSlug", unique = true, nullable = false)
    private String slug;
}

