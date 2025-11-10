package com.devmaster.lesson03.controller;

import com.devmaster.lesson03.entity.Student;
import com.devmaster.lesson03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")  // Đẹp hơn khi để gốc là /api
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 1. Lấy danh sách tất cả sinh viên
    // URL: GET http://localhost:8080/api/student-list
    @GetMapping("/student-list")
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    // 2. Lấy sinh viên theo id
    // URL: GET http://localhost:8080/api/student/1
    @GetMapping("/student/{id}")
    public Student getAllStudents(@PathVariable String id) {
        Long param = Long.parseLong(id);
        return studentService.getStudent(param);
    }

    // 3. Thêm mới sinh viên
    // URL: POST http://localhost:8080/api/student-add
    // Body: JSON của Student
    @PostMapping("/student-add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // 4. Cập nhật sinh viên
    // URL: PUT http://localhost:8080/api/student/1
    // Body: JSON của Student (có id trùng)
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable String id,
                                 @RequestBody Student student) {
        Long param = Long.parseLong(id);
        return studentService.updateStudent(param, student);
    }

    // 5. Xóa sinh viên
    // URL: DELETE http://localhost:8080/api/student/1
    @DeleteMapping("/student/{id}")
    public boolean deleteStudent(@PathVariable String id) {
        Long param = Long.parseLong(id);
        return studentService.deleteStudent(param);
    }
}