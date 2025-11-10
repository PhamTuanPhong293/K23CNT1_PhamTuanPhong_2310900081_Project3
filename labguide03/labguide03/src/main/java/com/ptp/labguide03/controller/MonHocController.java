package com.ptp.labguide03.controller;

import com.ptp.labguide03.entity.MonHoc;
import com.ptp.labguide03.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/monhoc")
public class MonHocController {
    @Autowired private MonHocService service;
    @GetMapping("") public List<MonHoc> getAll() { return service.getAll(); }
    @GetMapping("/{mamh}") public MonHoc getByMa(@PathVariable String mamh) { return service.getByMa(mamh); }
    @PostMapping("") public MonHoc add(@RequestBody MonHoc mh) { return service.add(mh); }
    @PutMapping("/{mamh}") public MonHoc update(@PathVariable String mamh, @RequestBody MonHoc mh) { return service.update(mamh, mh); }
    @DeleteMapping("/{mamh}") public boolean delete(@PathVariable String mamh) { return service.delete(mamh); }
}