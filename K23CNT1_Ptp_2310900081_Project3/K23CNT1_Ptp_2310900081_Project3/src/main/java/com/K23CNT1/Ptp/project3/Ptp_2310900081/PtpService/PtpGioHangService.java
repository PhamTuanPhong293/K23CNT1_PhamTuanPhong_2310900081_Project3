package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpService;

import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpEntity.PtpSanPham;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpModel.PtpCartItem;
import com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpRepository.PtpSanPhamRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PtpGioHangService {

    @Autowired
    private PtpSanPhamRepository sanPhamRepository;

    private static final String SESSION_CART_KEY = "ptp_gio_hang";

    // 1. Lấy giỏ hàng từ Session
    public List<PtpCartItem> getGioHang(HttpSession session) {
        List<PtpCartItem> cart = (List<PtpCartItem>) session.getAttribute(SESSION_CART_KEY);
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute(SESSION_CART_KEY, cart);
        }
        return cart;
    }

    // 2. Thêm sản phẩm vào giỏ
    public void themVaoGio(Long sanPhamId, HttpSession session) {
        List<PtpCartItem> cart = getGioHang(session);

        // Kiểm tra xem sản phẩm đã có trong giỏ chưa
        Optional<PtpCartItem> existingItem = cart.stream()
                .filter(item -> item.getProductId().equals(sanPhamId))
                .findFirst();

        if (existingItem.isPresent()) {
            // Nếu có rồi -> Tăng số lượng lên 1
            PtpCartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + 1);
        } else {
            // Nếu chưa có -> Lấy từ DB và thêm mới vào giỏ
            PtpSanPham sp = sanPhamRepository.findById(sanPhamId).orElse(null);
            if (sp != null) {
                PtpCartItem item = new PtpCartItem(
                        sp.getId(),
                        sp.getTenSanPham(),
                        sp.getAnhChinhUrl(),
                        sp.getGiaBan(),
                        1
                );
                cart.add(item);
            }
        }
        // Lưu ngược lại vào session
        session.setAttribute(SESSION_CART_KEY, cart);
    }

    // 3. Xóa sản phẩm khỏi giỏ
    public void xoaKhoiGio(Long sanPhamId, HttpSession session) {
        List<PtpCartItem> cart = getGioHang(session);
        cart.removeIf(item -> item.getProductId().equals(sanPhamId));
        session.setAttribute(SESSION_CART_KEY, cart);
    }

    // 4. Tính tổng tiền
    public BigDecimal getTongTien(HttpSession session) {
        List<PtpCartItem> cart = getGioHang(session);
        return cart.stream()
                .map(PtpCartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 5. Xóa sạch giỏ hàng (Sau khi thanh toán)
    public void xoaHetGioHang(HttpSession session) {
        session.removeAttribute("ptp_gio_hang"); // Xóa key session chứa giỏ hàng
    }
}