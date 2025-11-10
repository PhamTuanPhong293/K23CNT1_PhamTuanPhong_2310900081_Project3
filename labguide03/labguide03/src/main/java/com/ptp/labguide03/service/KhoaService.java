package com.ptp.labguide03.service;

import com.ptp.labguide03.entity.Khoa;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class KhoaService {
    private final List<Khoa> khoas = new ArrayList<>(List.of(
            new Khoa("CNTT", "Công nghệ thông tin"),
            new Khoa("KT", "Kế toán"),
            new Khoa("QTKD", "Quản trị kinh doanh"),
            new Khoa("NN", "Ngoại ngữ"),
            new Khoa("SP", "Sư phạm")
    ));

    public List<Khoa> getAll() { return khoas; }
    public Khoa getByMa(String makh) { return khoas.stream().filter(k -> k.makh().equals(makh)).findFirst().orElse(null); }
    public Khoa add(Khoa khoa) { khoas.add(khoa); return khoa; }
    public Khoa update(String makh, Khoa khoa) {
        Khoa k = getByMa(makh);
        if (k == null) return null;
        khoas.removeIf(item -> item.makh().equals(makh));
        khoas.add(khoa);
        return khoa;
    }
    public boolean delete(String makh) { return khoas.removeIf(k -> k.makh().equals(makh)); }
}