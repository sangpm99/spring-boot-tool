package tool.project.service;

import tool.project.models.Product;
import tool.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> listAll() { return repository.findAll(); }
    public Product get(Long productId) { return repository.findById(productId).orElse(null); }
    public Product save(Product product) { return repository.save(product); }
    public void delete(Long productId) { repository.deleteById(productId); }
}
