package tool.project.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tool.project.model.Product;
import tool.project.service.ProductService;

@RestController
@RequestMapping("/Product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/GetProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/CreateProducts")
    public void createProducts(@RequestBody List<Product> products) {
        productService.createProducts(products);
    }

    @PutMapping("/UpdateProduct/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/DeleteProduct")
    public void deleteProducts(@RequestParam("id") String idList) {
        List<Long> ids = Arrays.stream(idList.split(","))
                .map(Long::parseLong)
                .toList();
        productService.deleteProducts(ids);
    }
}
