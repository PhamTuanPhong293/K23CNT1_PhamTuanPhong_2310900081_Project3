package com.K23CNT1.Ptp.project3.Ptp_2310900081.PtpConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PtpWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Cấu hình để web hiển thị được ảnh từ thư mục lưu trữ trên máy tính
        // URL truy cập: http://localhost:8085/images/product-images/ten-anh.jpg
        // Thư mục vật lý: src/main/resources/static/images/product-images/

        registry.addResourceHandler("/images/product-images/**")
                .addResourceLocations("file:./src/main/resources/static/images/product-images/");
    }
}