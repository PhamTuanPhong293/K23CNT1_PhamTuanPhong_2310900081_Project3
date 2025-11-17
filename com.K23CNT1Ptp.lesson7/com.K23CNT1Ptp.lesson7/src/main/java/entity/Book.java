package entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "Qty")
    private int qty; // Số lượng (Quantity)

    @Column(name = "Price")
    private double price;

    @Column(name = "yearRelease")
    private int yearRelease;

    @Column(name = "author")
    private String author;

    @Column(name = "status")
    private boolean status;

    // Đây là cách tạo khóa ngoại (FK[categoryId])
    @ManyToOne // Nhiều Book sẽ thuộc về 1 Category
    @JoinColumn(name = "categoryId") // Tên cột khóa ngoại trong bảng Book
    private Category category;
}