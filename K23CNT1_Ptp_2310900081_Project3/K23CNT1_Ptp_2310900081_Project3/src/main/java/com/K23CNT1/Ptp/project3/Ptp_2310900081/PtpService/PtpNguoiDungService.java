package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpNguoiDung;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpNguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PtpNguoiDungService implements UserDetailsService {

    @Autowired
    private PtpNguoiDungRepository nguoiDungRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Bắt buộc để mã hóa mật khẩu

    // ================================================================
    // 1. PHẦN XÁC THỰC NGƯỜI DÙNG (SPRING SECURITY)
    // ================================================================
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm user theo username
        PtpNguoiDung nguoiDung = nguoiDungRepository.findByTenDangNhap(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng: " + username));

        // Trả về chính Entity (vì nó đã implements UserDetails)
        return nguoiDung;
    }

    // ================================================================
    // 2. PHẦN QUẢN LÝ DỮ LIỆU (CRUD CHO ADMIN)
    // ================================================================

    // Lấy tất cả danh sách (cho trang danh sách)
    public List<PtpNguoiDung> layTatCaNguoiDung() {
        return nguoiDungRepository.findAll();
    }

    // Lấy 1 người dùng theo ID (cho trang sửa)
    public PtpNguoiDung layNguoiDungTheoId(Long id) {
        return nguoiDungRepository.findById(id).orElse(null);
    }

    // Lưu người dùng (Thêm mới hoặc Cập nhật)
    public void luuNguoiDung(PtpNguoiDung nguoiDung) {
        // Logic mã hóa mật khẩu thông minh:

        // 1. Nếu là THÊM MỚI (ID là null) -> Luôn mã hóa
        if (nguoiDung.getId() == null) {
            nguoiDung.setMatKhau(passwordEncoder.encode(nguoiDung.getMatKhau()));
        }
        // 2. Nếu là CẬP NHẬT (Sửa)
        else {
            PtpNguoiDung oldUser = nguoiDungRepository.findById(nguoiDung.getId()).orElse(null);
            if (oldUser != null) {
                // Nếu ô mật khẩu trống -> Giữ nguyên mật khẩu cũ
                if (nguoiDung.getMatKhau() == null || nguoiDung.getMatKhau().isEmpty()) {
                    nguoiDung.setMatKhau(oldUser.getMatKhau());
                }
                // Nếu có nhập mật khẩu mới và khác mật khẩu cũ -> Mã hóa lại
                else if (!nguoiDung.getMatKhau().equals(oldUser.getMatKhau())) {
                    nguoiDung.setMatKhau(passwordEncoder.encode(nguoiDung.getMatKhau()));
                }
            }
        }

        nguoiDungRepository.save(nguoiDung);
    }

    // Xóa người dùng
    public void xoaNguoiDung(Long id) {
        nguoiDungRepository.deleteById(id);
    }
}