package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpDonHang;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpTrangThaiDonHang;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpDonHangRepository;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpTrangThaiDonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PtpDonHangService {

    @Autowired
    private PtpDonHangRepository donHangRepository;

    @Autowired
    private PtpTrangThaiDonHangRepository trangThaiRepository;

    // READ: Lấy tất cả đơn hàng (cho Admin)
    public List<PtpDonHang> layTatCaDonHang() {
        return donHangRepository.findAll();
    }

    // READ: Lấy đơn hàng theo ID
    public Optional<PtpDonHang> layDonHangTheoId(Long id) {
        return donHangRepository.findById(id);
    }

    // READ: Lấy tất cả trạng thái (cho Dropdown cập nhật)
    public List<PtpTrangThaiDonHang> layTatCaTrangThai() {
        return trangThaiRepository.findAll();
    }

    // UPDATE: Cập nhật trạng thái đơn hàng
    public void capNhatTrangThaiDonHang(Long donHangId, Long trangThaiId) {
        PtpDonHang donHang = donHangRepository.findById(donHangId)
                .orElseThrow(() -> new IllegalArgumentException("ID Đơn hàng không hợp lệ: " + donHangId));

        PtpTrangThaiDonHang trangThaiMoi = trangThaiRepository.findById(trangThaiId)
                .orElseThrow(() -> new IllegalArgumentException("ID Trạng thái không hợp lệ: " + trangThaiId));

        donHang.setTrangThai(trangThaiMoi);
        donHangRepository.save(donHang);
    }
}   