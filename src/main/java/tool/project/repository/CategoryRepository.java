package tool.project.repository;
import tool.project.model.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT * from categories", nativeQuery = true)
    List<Category> getCategories();

    @Query(value = "SELECT * FROM categories LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Category> getAllCategories(@Param("limit") int limit, @Param("offset") int offset);

    @Query(value = "SELECT COUNT(*) FROM categories", nativeQuery = true)
    int countAllCategories();

    @Query(value = "SELECT * FROM categories WHERE name LIKE %:search% LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Category> searchCategories(@Param("search") String search, @Param("limit") int limit, @Param("offset") int offset);

    @Query(value = "SELECT COUNT(*) FROM categories WHERE name LIKE %:search%", nativeQuery = true)
    int countSearchCategories(@Param("search") String search);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categories (name, slug) values (:name, :slug)", nativeQuery = true)
    void insertCategory(String name, String slug);

    @Modifying
    @Transactional
    @Query(value = "UPDATE categories SET name = :name, slug = :slug WHERE id = :id", nativeQuery = true)
    void updateCategory(Long id, String name, String slug);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM categories WHERE id = :id", nativeQuery = true)
    void deleteCategoryById(Long id);
}
