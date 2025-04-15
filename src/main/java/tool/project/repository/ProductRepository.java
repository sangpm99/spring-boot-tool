package tool.project.repository;
import tool.project.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<Product> getAllProducts();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO products (name, price, category_id) VALUES (:name, :price, :category_id)", nativeQuery = true)
    void insertProducts(List<String> name, List<Double> price, List<Long> categoryId);
}
