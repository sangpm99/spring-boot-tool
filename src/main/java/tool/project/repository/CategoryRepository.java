package tool.project.repository;
import tool.project.model.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT * from categories", nativeQuery = true)
    List<Category> getCategories();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categories (name, slug) values (:name, :slug)", nativeQuery = true)
    void insertCategory(String name, String slug);
}
