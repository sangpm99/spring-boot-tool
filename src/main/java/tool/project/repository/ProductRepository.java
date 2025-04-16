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

    @Query(value = """
        WITH selected_variables AS (
            SELECT p.id 
            FROM products p
            JOIN products_categories pc ON p.id = pc.product_id
            WHERE p.type = 'variable' AND pc.category_id = :categoryId
            ORDER BY RAND()
            LIMIT :quantity
        ),
        all_records AS (
            SELECT p.*, 
                CASE 
                    WHEN p.type = 'variable' THEN p.id 
                    ELSE SUBSTRING_INDEX(p.parent, ':', -1) 
                END AS group_id,
                CASE 
                    WHEN p.type = 'variable' THEN 0 
                    ELSE 1 
                END AS record_order
            FROM products p
            WHERE 
                (p.type = 'variable' AND p.id IN (SELECT id FROM selected_variables))
                OR
                (p.type = 'variation' AND p.parent IN (
                    SELECT CONCAT('id:', id) FROM selected_variables
                ))
        )
        SELECT * 
        FROM all_records
        ORDER BY group_id, record_order, id
    """, nativeQuery = true)
    List<Product> getRandomVariableAndVariationsByCategory(@Param("categoryId") Long categoryId, @Param("quantity") int quantity);
}
