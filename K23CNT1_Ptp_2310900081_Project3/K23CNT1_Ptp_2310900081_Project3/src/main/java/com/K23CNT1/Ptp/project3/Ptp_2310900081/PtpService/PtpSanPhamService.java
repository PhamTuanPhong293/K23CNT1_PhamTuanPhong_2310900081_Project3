package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpSanPham;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PtpSanPhamService {

    @Autowired
    private PtpSanPhamRepository sanPhamRepository;

    @Value("${ptp.upload.path}")
    private String uploadPath;

    // 1. Lấy danh sách (Tên hàm khớp với Controller)
    public List<PtpSanPham> layDanhSachSanPham() {
        return sanPhamRepository.findAll();
    }

    // 2. Lấy chi tiết (Dùng cho chức năng Sửa)
    public Optional<PtpSanPham> laySanPhamTheoId(Long id) {
        return sanPhamRepository.findById(id);
    }

    // 3. Xử lý Lưu (Thêm mới & Cập nhật)
    public void luuSanPham(PtpSanPham sanPham, MultipartFile file) {
        try {
            // --- XỬ LÝ ẢNH ---
            if (file != null && !file.isEmpty()) {
                // A. Nếu có upload ảnh mới -> Lưu ảnh và gán đường dẫn
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Path path = Paths.get(uploadPath);

                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                }
                Files.copy(file.getInputStream(), path.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

                sanPham.setAnhChinhUrl("/images/product-images/" + fileName);
            } else {
                // B. Nếu KHÔNG chọn ảnh mới
                if (sanPham.getId() != null) {
                    // Nếu đang Sửa -> Tìm sản phẩm cũ để lấy lại URL ảnh cũ
                    Optional<PtpSanPham> sanPhamCu = sanPhamRepository.findById(sanPham.getId());
                    sanPhamCu.ifPresent(cu -> sanPham.setAnhChinhUrl(cu.getAnhChinhUrl()));
                }
            }

            // --- XỬ LÝ DỮ LIỆU MẶC ĐỊNH ---
            // Nếu chưa có trạng thái -> Mặc định là True (Hoạt động)
            if (sanPham.getTrangThaiHoatDong() == null) {
                sanPham.setTrangThaiHoatDong(true);
            }

            // Tạo Slug nếu chưa có
            if (sanPham.getSlug() == null || sanPham.getSlug().isEmpty()) {
                sanPham.setSlug(sanPham.getTenSanPham().toLowerCase().replace(" ", "-"));
            }

            // --- LƯU VÀO CSDL ---
            sanPhamRepository.save(sanPham);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4. Xóa sản phẩm
    public void xoaSanPham(Long id) {
        sanPhamRepository.deleteById(id);
    }
}