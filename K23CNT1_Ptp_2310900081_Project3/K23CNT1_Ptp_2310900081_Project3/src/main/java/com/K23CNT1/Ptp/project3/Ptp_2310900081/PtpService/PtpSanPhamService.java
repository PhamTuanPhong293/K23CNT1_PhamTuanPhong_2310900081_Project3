package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpSanPham;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Đường dẫn thư mục chứa ảnh (trong project)
    private final String uploadPath = "src/main/resources/static/images/";

    // 1. Lấy tất cả sản phẩm (Sửa tên hàm cho khớp với Controller)
    public List<PtpSanPham> layTatCaSanPham() {
        return sanPhamRepository.findAll();
    }

    // 2. Lấy sản phẩm theo ID
    public Optional<PtpSanPham> laySanPhamTheoId(Long id) {
        return sanPhamRepository.findById(id);
    }

    // 3. Lưu sản phẩm (Xử lý upload ảnh)
    public void luuSanPham(PtpSanPham sanPham, MultipartFile file) {
        try {
            // --- XỬ LÝ ẢNH ---
            if (file != null && !file.isEmpty()) {
                // Tạo tên file ngẫu nhiên để tránh trùng
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Path path = Paths.get(uploadPath);

                // Tạo thư mục nếu chưa có
                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                }
                // Lưu file vật lý
                Files.copy(file.getInputStream(), path.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

                // Gán đường dẫn vào Entity (SỬA LẠI TÊN BIẾN CHO KHỚP ENTITY)
                // Lưu ý: Thêm "/images/" để file HTML hiển thị được ngay
                sanPham.setAnhChinhUrl("/images/" + fileName);
            } else {
                // Nếu không up ảnh mới -> Giữ lại ảnh cũ
                if (sanPham.getId() != null) {
                    Optional<PtpSanPham> sanPhamCu = sanPhamRepository.findById(sanPham.getId());
                    if (sanPhamCu.isPresent()) {
                        // SỬA LẠI TÊN BIẾN: getAnhChinhUrl
                        sanPham.setAnhChinhUrl(sanPhamCu.get().getAnhChinhUrl());
                    }
                }
            }

            // --- XỬ LÝ DỮ LIỆU KHÁC ---
            if (sanPham.getTrangThaiHoatDong() == null) {
                sanPham.setTrangThaiHoatDong(true);
            }

            // Tạo Slug nếu chưa có (dùng cho SEO url sau này)
            if (sanPham.getSlug() == null || sanPham.getSlug().isEmpty()) {
                String slug = sanPham.getTenSanPham().toLowerCase().replace(" ", "-");
                sanPham.setSlug(slug);
            }

            // Lưu vào DB
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