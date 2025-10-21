package com.ptphong.lesson02.ioc;

public class IocClient {
    // Chỉ phụ thuộc vào Interface
    private IocService iocService;

    // Dependency được "tiêm" vào qua constructor
    public IocClient(IocService iocService) {
        this.iocService = iocService;
    }

    public void doSomething() {
        iocService.serve();
    }
}