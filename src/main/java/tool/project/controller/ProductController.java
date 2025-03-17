package tool.project.controller;

import tool.project.models.Product;
import tool.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
@CrossOrigin(origins = "*")  // Cho phép CORS
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/GetProducts")
    public List<Product> listAll() {
        return service.listAll();
    }

    @GetMapping("/GetProduct/{productId}")
    public Product get(@PathVariable Long productId) {
        return service.get(productId);
    }

    @PostMapping("/CreateProduct")
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/UpdateProduct/{productId}")
    public Product update(@PathVariable Long productId, @RequestBody Product product) {
        product.setProductId(productId);
        return service.save(product);
    }

    @DeleteMapping("DeleteProduct/{productId}")
    public void delete(@PathVariable Long productId) {
        service.delete(productId);
    }
}
