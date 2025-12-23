package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpDanhMuc;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpDanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PtpDanhMucService {

    @Autowired
    private PtpDanhMucRepository danhMucRepository;

    // Phương thức lấy tất cả danh mục (để dùng cho Dropdown)
    public List<PtpDanhMuc> layTatCaDanhMuc() {
        return danhMucRepository.findAll();
    }
}