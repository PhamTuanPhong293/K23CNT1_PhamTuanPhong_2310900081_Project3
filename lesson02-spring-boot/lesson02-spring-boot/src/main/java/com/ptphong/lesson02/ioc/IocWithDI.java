package com.ptphong.lesson02.ioc;

public class IocWithDI {
    public static void main(String[] args) {
        // 1. Tạo đối tượng service
        IocService service = new MyServiceImpl();

        // 2. "Tiêm" service vào client
        IocClient client = new IocClient(service);

        // 3. Chạy
        client.doSomething();
    }
}