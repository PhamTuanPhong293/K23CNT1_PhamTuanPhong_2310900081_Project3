package com.ptp.labguide03.service;

import com.ptp.labguide03.entity.MonHoc;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonHocService {
    private final List<MonHoc> monhocs = new ArrayList<>(List.of(
            new MonHoc("JAVA", "Lập trình Java", 45),
            new MonHoc("WEB", "Thiết kế Web", 30),
            new MonHoc("DB", "Cơ sở dữ liệu", 45),
            new MonHoc("MOB", "Lập trình Mobile", 60),
            new MonHoc("AI", "Trí tuệ nhân tạo", 50)
    ));

    public List<MonHoc> getAll() { return monhocs; }
    public MonHoc getByMa(String mamh) { return monhocs.stream().filter(m -> m.mamh().equals(mamh)).findFirst().orElse(null); }
    public MonHoc add(MonHoc mh) { monhocs.add(mh); return mh; }
    public MonHoc update(String mamh, MonHoc mh) {
        MonHoc m = getByMa(mamh);
        if (m == null) return null;
        monhocs.removeIf(item -> item.mamh().equals(mamh));
        monhocs.add(mh);
        return mh;
    }
    public boolean delete(String mamh) { return monhocs.removeIf(m -> m.mamh().equals(mamh)); }
}