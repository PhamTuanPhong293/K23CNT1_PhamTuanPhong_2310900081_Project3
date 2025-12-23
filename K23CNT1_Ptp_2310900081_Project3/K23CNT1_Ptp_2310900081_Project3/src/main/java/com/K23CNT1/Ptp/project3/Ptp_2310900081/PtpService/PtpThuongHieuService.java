package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpThuongHieu;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PtpThuongHieuService {

    @Autowired
    private PtpThuongHieuRepository thuongHieuRepository;

    // Phương thức lấy tất cả thương hiệu (để dùng cho Dropdown)
    public List<PtpThuongHieu> layTatCaThuongHieu() {
        return thuongHieuRepository.findAll();
    }
}