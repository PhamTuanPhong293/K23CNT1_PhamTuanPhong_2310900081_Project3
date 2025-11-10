package com.ptp.labguide03.controller;

import com.ptp.labguide03.entity.Khoa;
import com.ptp.labguide03.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/khoa")
public class KhoaController {
    @Autowired private KhoaService service;
    @GetMapping("") public List<Khoa> getAll() { return service.getAll(); }
    @GetMapping("/{makh}") public Khoa getByMa(@PathVariable String makh) { return service.getByMa(makh); }
    @PostMapping("") public Khoa add(@RequestBody Khoa khoa) { return service.add(khoa); }
    @PutMapping("/{makh}") public Khoa update(@PathVariable String makh, @RequestBody Khoa khoa) { return service.update(makh, khoa); }
    @DeleteMapping("/{makh}") public boolean delete(@PathVariable String makh) { return service.delete(makh); }
}