package com.devmaster.lesson03.service;

import com.devmaster.lesson03.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {   // ĐÃ ĐỔI TÊN ĐÚNG

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.addAll(Arrays.asList(
                new Student(1L, "Devmaster 1", 20, "Non", "Số 25 VNP", "0978611889", "chungtrinhj@gmail.com"),
                new Student(2L, "Devmaster 2", 25, "Non", "Số 25 VNP", "0978611889", "contact@devmaster.edu.vn"),
                new Student(3L, "Devmaster 3", 22, "Non", "Số 25 VNP", "0978611889", "chungtrinhj@gmail.com")
        ));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudent(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // SỬA LẠI: TỰ SINH ID KHI THÊM MỚI
    public Student addStudent(Student student) {
        Long newId = students.stream()
                .mapToLong(Student::getId)
                .max()
                .orElse(0L) + 1;
        student.setId(newId);  // TỰ ĐỘNG GÁN ID
        students.add(student);
        return student;
    }

    // SỬA LẠI: CẬP NHẬT CHUẨN HƠN
    public Student updateStudent(Long id, Student student) {
        Student existing = getStudent(id);
        if (existing == null) {
            return null;
        }
        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setGender(student.getGender());
        existing.setAddress(student.getAddress());
        existing.setPhone(student.getPhone());
        existing.setEmail(student.getEmail());
        return existing;  // TRẢ VỀ ĐỐI TƯỢNG ĐÃ CẬP NHẬT
    }

    public boolean deleteStudent(Long id) {
        Student check = getStudent(id);
        return check != null && students.remove(check);
    }
}