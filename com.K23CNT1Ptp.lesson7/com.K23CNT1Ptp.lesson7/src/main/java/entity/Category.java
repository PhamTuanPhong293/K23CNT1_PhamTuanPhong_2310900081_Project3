package entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Tự động tạo getter, setter, toString...
@NoArgsConstructor // Tự động tạo constructor không tham số
@AllArgsConstructor // Tự động tạo constructor có tham số
@Entity // Báo cho Spring Boot đây là một Entity (thực thể)
@Table(name = "Category") // Tên bảng trong database
public class Category {

    @Id // Đánh dấu đây là khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID tự động tăng
    private int id;

    @Column(name = "name") // Tên cột, có thể bỏ qua nếu tên cột trùng tên biến
    private String name;

    @Column(name = "status")
    private boolean status;
}