package controller;

import entity.Category;
import service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Báo cho Spring Boot biết đây là 1 API Controller
@RequestMapping("/api/categories") // Đường dẫn gốc cho tất cả API trong class này
public class CategoryController {

    @Autowired // Tự động tiêm CategoryService
    private CategoryService categoryService;

    // 1. API lấy tất cả Category (READ)
    // HTTP Method: GET
    // URL: http://localhost:8080/api/categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // 2. API lấy Category theo ID (READ)
    // HTTP Method: GET
    // URL: http://localhost:8080/api/categories/1 (số 1 là id)
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id)
                .map(category -> ResponseEntity.ok().body(category)) // Nếu tìm thấy (status 200)
                .orElse(ResponseEntity.notFound().build()); // Nếu không tìm thấy (status 404)
    }

    // 3. API tạo mới Category (CREATE)
    // HTTP Method: POST
    // URL: http://localhost:8080/api/categories
    // Body (JSON): {"name": "Tên Category", "status": true}
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category newCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory); // Trả về status 201
    }

    // 4. API cập nhật Category (UPDATE)
    // HTTP Method: PUT
    // URL: http://localhost:8080/api/categories/1
    // Body (JSON): {"name": "Tên mới", "status": false}
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category categoryDetails) {
        try {
            Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
            return ResponseEntity.ok().body(updatedCategory); // Status 200
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Status 404
        }
    }

    // 5. API xóa Category (DELETE)
    // HTTP Method: DELETE
    // URL: http://localhost:8080/api/categories/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build(); // Trả về status 204 (No Content)

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Status 404
        }
    }
}