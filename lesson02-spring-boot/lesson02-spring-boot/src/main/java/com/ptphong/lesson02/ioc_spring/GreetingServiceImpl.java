package com.ptphong.lesson02.ioc_spring;

import org.springframework.stereotype.Service;

@Service // Báo cho Spring đây là một Bean dịch vụ
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String name) {
        return "<h2>Devmaster[Spring Boot!] Xin chào, </h2>" +
                "<h1 style='color:red; text-align:center'>" + name + "</h1>";
    }
}