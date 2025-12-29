package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PtpCartItem {
    private Long productId;
    private String productName;
    private String productImage;
    private BigDecimal price;
    private int quantity;

    // Tính thành tiền = giá x số lượng
    public BigDecimal getTotalPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}