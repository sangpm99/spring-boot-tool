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
        for (Product p : products) {
            productRepository.save(p);
        }
    }

    public void updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setCategory(updatedProduct.getCategory());
            productRepository.save(existingProduct);
        }
    }

    public void deleteProducts(List<Long> ids) {
        productRepository.deleteAllById(ids);
    }
}
