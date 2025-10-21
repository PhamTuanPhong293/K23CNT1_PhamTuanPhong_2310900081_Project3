package com.ptphong.lesson02.ioc;

public class Client {
    private Service service; // Phụ thuộc vào lớp Service cụ thể

    public Client() {
        // Client tự tạo đối tượng Service
        service = new Service();
    }

    public void doSomething() {
        service.serve();
    }
}