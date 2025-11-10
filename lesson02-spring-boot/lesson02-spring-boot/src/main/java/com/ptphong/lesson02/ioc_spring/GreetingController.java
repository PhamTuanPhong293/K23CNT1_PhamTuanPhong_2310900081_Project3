package com.ptphong.lesson02.ioc_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Báo cho Spring đây là một Controller xử lý API
public class GreetingController {

    // Chỉ phụ thuộc vào Interface
    private final GreetingService greetingService;

    // Sử dụng Constructor-based Dependency Injection
    // Spring sẽ tự tìm Bean GreetingServiceImpl và "tiêm" vào đây
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Khi ai đó truy cập /greet, chạy hàm này
    @GetMapping("/greet")
    public String greet() {
        // Sử dụng service đã được tiêm
        return greetingService.greet("Chung Trịnh");
    }
}