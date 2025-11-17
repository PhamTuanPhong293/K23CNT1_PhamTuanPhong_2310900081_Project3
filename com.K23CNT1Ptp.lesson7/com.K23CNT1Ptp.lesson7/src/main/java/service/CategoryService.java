package service;


import entity.Category;
import repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Báo cho Spring Boot biết đây là 1 Service
public class CategoryService {

    @Autowired // Tự động tiêm (inject) CategoryRepository vào service
    private CategoryRepository categoryRepository;

    // 1. Hàm lấy tất cả Category (READ)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // 2. Hàm lấy Category theo ID (READ)
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }

    // 3. Hàm tạo mới Category (CREATE)
    public Category createCategory(Category category) {
        // Bạn có thể thêm logic kiểm tra ở đây, ví dụ:
        // if (categoryRepository.existsByName(category.getName())) {
        //     throw new RuntimeException("Tên category đã tồn tại");
        // }
        return categoryRepository.save(category);
    }

    // 4. Hàm cập nhật Category (UPDATE)
    public Category updateCategory(int id, Category categoryDetails) {
        // Tìm category cũ
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Category với id: " + id));

        // Cập nhật thông tin
        category.setName(categoryDetails.getName());
        category.setStatus(categoryDetails.isStatus());

        // Lưu lại category đã cập nhật
        return categoryRepository.save(category);
    }

    // 5. Hàm xóa Category (DELETE)
    public void deleteCategory(int id) {
        // Kiểm tra xem category có tồn tại không
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Category với id: " + id));

        // Bạn cũng nên kiểm tra xem category này có đang được
        // sử dụng bởi Book nào không trước khi xóa

        categoryRepository.delete(category);
    }
}
