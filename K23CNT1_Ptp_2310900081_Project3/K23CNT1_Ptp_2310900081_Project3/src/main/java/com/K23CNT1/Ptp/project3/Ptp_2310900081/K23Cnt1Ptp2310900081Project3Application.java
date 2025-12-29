package com.K23CNT1.Ptp.project3.Ptp_2310900081;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpNguoiDung;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpDanhMuc;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpThuongHieu;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpTrangThaiDonHang;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpNguoiDungRepository;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpDanhMucRepository;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpThuongHieuRepository;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpTrangThaiDonHangRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
// 👇 DÒNG 1: Chỉ định rõ nơi chứa Repository (Sửa lỗi Bean not found)
@EnableJpaRepositories(basePackages = "com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository")
// 👇 DÒNG 2: Chỉ định rõ nơi chứa Entity (Sửa lỗi Not a managed type)
@EntityScan(basePackages = "com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity")
// 👇 DÒNG 3: Quét toàn bộ Component/Service/Controller
@ComponentScan(basePackages = "com.K23CNT1.Ptp.project3.Ptp_2310900081")
public class K23Cnt1Ptp2310900081Project3Application {

    public static void main(String[] args) {
        SpringApplication.run(K23Cnt1Ptp2310900081Project3Application.class, args);
    }

    @Bean
    public CommandLineRunner initData(
            PtpNguoiDungRepository nguoiDungRepo,
            PasswordEncoder passwordEncoder,
            PtpDanhMucRepository danhMucRepo,
            PtpThuongHieuRepository thuongHieuRepo,
            PtpTrangThaiDonHangRepository trangThaiRepo) {
        return args -> {

            // 1. Data Seeding Admin
            if (nguoiDungRepo.count() == 0) {
                PtpNguoiDung admin = new PtpNguoiDung();
                admin.setTenDangNhap("admin");
                admin.setMatKhau(passwordEncoder.encode("123456"));
                admin.setVaiTro(PtpNguoiDung.UserRole.ADMIN);
                admin.setHoTen("Admin Hệ thống");
                admin.setEmail("admin@ptp.com");
                admin.setTrangThaiHoatDong(true);
                admin.setSoDienThoai("0999999999"); // Thêm cho đầy đủ
                admin.setDiaChi("Hà Nội");          // Thêm cho đầy đủ

                nguoiDungRepo.save(admin);
                System.out.println(">>> Đã tạo tài khoản Admin: admin/123456");
            }

            // 2. Data Seeding Danh mục
            if (danhMucRepo.count() == 0) {
                danhMucRepo.save(new PtpDanhMuc(null, "Giày chạy bộ", "giay-chay-bo"));
                danhMucRepo.save(new PtpDanhMuc(null, "Giày bóng rổ", "giay-bong-ro"));
                danhMucRepo.save(new PtpDanhMuc(null, "Giày thời trang", "giay-thoi-trang"));
                System.out.println(">>> Đã tạo 3 Danh mục mẫu.");
            }

            // 3. Data Seeding Thương hiệu
            if (thuongHieuRepo.count() == 0) {
                thuongHieuRepo.save(new PtpThuongHieu(null, "Nike", "nike"));
                thuongHieuRepo.save(new PtpThuongHieu(null, "Adidas", "adidas"));
                thuongHieuRepo.save(new PtpThuongHieu(null, "Puma", "puma"));
                System.out.println(">>> Đã tạo 3 Thương hiệu mẫu.");
            }

            // 4. Data Seeding Trạng thái
            if (trangThaiRepo.count() == 0) {
                trangThaiRepo.save(new PtpTrangThaiDonHang(null, "MỚI", "Đơn hàng vừa được đặt thành công."));
                trangThaiRepo.save(new PtpTrangThaiDonHang(null, "ĐANG XỬ LÝ", "Đơn hàng đang được chuẩn bị."));
                trangThaiRepo.save(new PtpTrangThaiDonHang(null, "ĐANG GIAO", "Đơn hàng đang trên đường giao."));
                trangThaiRepo.save(new PtpTrangThaiDonHang(null, "HOÀN THÀNH", "Đơn hàng đã giao thành công."));
                trangThaiRepo.save(new PtpTrangThaiDonHang(null, "ĐÃ HỦY", "Đơn hàng đã bị hủy."));
                System.out.println(">>> Đã tạo 5 Trạng thái Đơn hàng mặc định.");
            }
        };
    }
}