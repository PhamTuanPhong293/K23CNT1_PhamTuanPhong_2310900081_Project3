package com.ptp.labguide03.controller;

import com.ptp.labguide03.entity.Employee;
import com.ptp.labguide03.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired private EmployeeService service;
    @GetMapping("") public List<Employee> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public Employee getById(@PathVariable Long id) { return service.getById(id); }
    @PostMapping("") public Employee add(@RequestBody Employee emp) { return service.add(emp); }
    @PutMapping("/{id}") public Employee update(@PathVariable Long id, @RequestBody Employee emp) { return service.update(id, emp); }
    @DeleteMapping("/{id}") public boolean delete(@PathVariable Long id) { return service.delete(id); }
}