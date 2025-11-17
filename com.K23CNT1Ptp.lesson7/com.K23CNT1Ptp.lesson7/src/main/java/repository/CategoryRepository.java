package repository;



import entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Chỉ cần như vậy là JpaRepository đã cung cấp cho chúng ta
    // đầy đủ các hàm CRUD cơ bản:
    // - save() (dùng cho cả Create và Update)
    // - findById() (Read)
    // - findAll() (Read all)
    // - deleteById() (Delete)
    // - ... và nhiều hàm khác
}
