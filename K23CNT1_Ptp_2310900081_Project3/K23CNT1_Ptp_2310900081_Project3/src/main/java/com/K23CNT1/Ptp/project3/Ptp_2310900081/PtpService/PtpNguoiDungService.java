package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpNguoiDung;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpNguoiDungRepository;

// Thêm các thư viện Spring cần thiết
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; // Interface BẮT BUỘC
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
// LỚI SỬA 1: PHẢI IMPLEMENT interface UserDetailsService chuẩn của Spring Security
public class PtpNguoiDungService implements UserDetailsService {

    @Autowired
    private PtpNguoiDungRepository nguoiDungRepository;

    // LỖI SỬA 2: Đảm bảo signature (tên và kiểu trả về) đúng của phương thức @Override
    @Override
    public PtpNguoiDung loadUserByUsername(String username) throws UsernameNotFoundException {

        // Spring Data JPA sẽ tìm theo tên đăng nhập
        PtpNguoiDung nguoiDung = nguoiDungRepository.findByTenDangNhap(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng: " + username));

        // LỖI SỬA 3: Trả về Entity PtpNguoiDung (lớp này đã implements UserDetails),
        //  đây là kiểu trả về hợp lệ cho phương thức này.
        return nguoiDung;
    }
}