package pl.coderslab.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
