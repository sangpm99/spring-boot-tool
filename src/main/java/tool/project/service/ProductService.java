package tool.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tool.project.model.Product;
import tool.project.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Map<String, Object> getProducts(int pageIndex, int pageSize, String searchValue, Long categoryId) {
        int offset = (pageIndex - 1) * pageSize;

        List<Product> items;
        int itemsCount;

        if (searchValue != null && !searchValue.isEmpty() && categoryId != null) {
            items = productRepository.searchByNameAndCategory(searchValue, categoryId, pageSize, offset);
            itemsCount = productRepository.countByNameAndCategory(searchValue, categoryId);
        } else if (searchValue != null && !searchValue.isEmpty()) {
            items = productRepository.searchByName(searchValue, pageSize, offset);
            itemsCount = productRepository.countByName(searchValue);
        } else if (categoryId != null) {
            items = productRepository.searchByCategory(categoryId, pageSize, offset);
            itemsCount = productRepository.countByCategory(categoryId);
        } else {
            items = productRepository.getAllProducts(pageSize, offset);
            itemsCount = productRepository.countAllProducts();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("pageIndex", pageIndex);
        result.put("pageSize", pageSize);
        result.put("itemsCount", itemsCount);
        result.put("items", items);

        return result;
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
