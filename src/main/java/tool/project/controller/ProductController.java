package tool.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
