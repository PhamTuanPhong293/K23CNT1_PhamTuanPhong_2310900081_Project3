package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "PtpNguoiDung") // Ánh xạ tới tên bảng trong MySQL
@Data // Lombok: Tự động tạo Getter, Setter, v.v.
@NoArgsConstructor // Lombok: Constructor không tham số (cần cho JPA)
@AllArgsConstructor
public class PtpNguoiDung implements UserDetails {

    // Khóa chính: PtpId (BIGINT -> Long)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PtpId")
    private Long id;

    // Các thuộc tính cơ bản
    @Column(name = "PtpTenDangNhap", unique = true, nullable = false, length = 50)
    private String tenDangNhap;

    @Column(name = "PtpMatKhau", nullable = false)
    private String matKhau;

    @Column(name = "PtpHoTen")
    private String hoTen;

    @Column(name = "PtpEmail", unique = true, nullable = false)
    private String email;

    @Column(name = "PtpSoDienThoai")
    private String soDienThoai;

    @Column(name = "PtpDiaChi")
    private String diaChi;

    // Vai trò: PtpVaiTro (ENUM)
    @Enumerated(EnumType.STRING)
    @Column(name = "PtpVaiTro", nullable = false)
    private UserRole vaiTro;

    // Trạng thái: PtpTrangThaiHoatDong (BOOLEAN)
    @Column(name = "PtpTrangThaiHoatDong")
    private Boolean trangThaiHoatDong;

    // --- Phương thức BẮT BUỘC của UserDetails (Để Spring Security hoạt động) ---

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Ánh xạ vai trò (UserRole) thành quyền hạn (Authority)
        return List.of(new SimpleGrantedAuthority(vaiTro.name()));
    }

    @Override
    public String getPassword() {
        return matKhau;
    }

    @Override
    public String getUsername() {
        return tenDangNhap;
    }

    // Các thiết lập trạng thái tài khoản
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Kiểm tra cột PtpTrangThaiHoatDong
        return trangThaiHoatDong != null && trangThaiHoatDong;
    }

    public enum UserRole {
        ADMIN, USER, KHO;
    }
}