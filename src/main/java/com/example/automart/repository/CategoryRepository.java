package  com.example.automart.repository;

import  com.example.automart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String name);
}
