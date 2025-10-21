package com.ptphong.lesson02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext; // Thêm import này

@SpringBootApplication
public class Lesson02SpringBootApplication {

    public static void main(String[] args) {
        // SpringApplication.run sẽ trả về "Context" (thùng chứa các Bean)
        ApplicationContext context = SpringApplication.run(Lesson02SpringBootApplication.class, args);

        // Lấy Bean 'LooseCouplingService' từ Spring
        LooseCouplingService service = context.getBean(LooseCouplingService.class);

        // Dữ liệu mẫu để test
        int[] data = {1, 21, 15, 42, 13};

        // Chạy logic
        service.complexBusinessSort(data);
    }
}