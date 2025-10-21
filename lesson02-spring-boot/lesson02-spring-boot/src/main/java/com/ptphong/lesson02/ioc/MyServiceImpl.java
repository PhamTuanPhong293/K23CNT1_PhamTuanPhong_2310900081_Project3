package com.ptphong.lesson02.ioc;

// Đây là lớp thực thi "hợp đồng" IocService
public class MyServiceImpl implements IocService {
    @Override
    public void serve() {
        System.out.println("IocService is serving");
    }
}