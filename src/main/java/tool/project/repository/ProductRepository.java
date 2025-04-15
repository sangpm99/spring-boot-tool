package tool.project.repository;
import tool.project.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<Product> getAllProducts();

    @Query(value = "SELECT * FROM products LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Product> getAllProducts(@Param("limit") int limit, @Param("offset") int offset);

    @Query(value = "SELECT COUNT(*) FROM products", nativeQuery = true)
    int countAllProducts();

    @Query(value = "SELECT * FROM products WHERE name LIKE %:search% LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Product> searchByName(@Param("search") String search, @Param("limit") int limit, @Param("offset") int offset);

    @Query(value = "SELECT COUNT(*) FROM products WHERE name LIKE %:search%", nativeQuery = true)
    int countByName(@Param("search") String search);

    @Query(value = "SELECT p.* FROM products p JOIN products_categories pc ON p.id = pc.product_id WHERE pc.category_id = :categoryId LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Product> searchByCategory(@Param("categoryId") Long categoryId, @Param("limit") int limit, @Param("offset") int offset);

    @Query(value = "SELECT COUNT(*) FROM products p JOIN products_categories pc ON p.id = pc.product_id WHERE pc.category_id = :categoryId", nativeQuery = true)
    int countByCategory(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT p.* FROM products p JOIN products_categories pc ON p.id = pc.product_id WHERE p.name LIKE %:search% AND pc.category_id = :categoryId LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Product> searchByNameAndCategory(@Param("search") String search, @Param("categoryId") Long categoryId, @Param("limit") int limit, @Param("offset") int offset);

    @Query(value = "SELECT COUNT(*) FROM products p JOIN products_categories pc ON p.id = pc.product_id WHERE p.name LIKE %:search% AND pc.category_id = :categoryId", nativeQuery = true)
    int countByNameAndCategory(@Param("search") String search, @Param("categoryId") Long categoryId);
}
