package tool.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tool.project.model.Product;
import tool.project.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.getAllProducts();
    }

    public void createProducts(List<Product> products) {
        for(Product product: products) {
            productRepository.insertProducts(
                List.of(product.getName()),
                List.of(product.getPrice()),
                List.of(product.getCategory().getId())
            );
        }
    }
}
