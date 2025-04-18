package tool.project.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/GetProducts")
    public Map<String, Object> getProducts(
            @RequestParam(defaultValue = "1") int pageIndex,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(required = false) String searchValue,
            @RequestParam(required = false) Long categoryId
    ) {
        return productService.getProducts(pageIndex, pageSize, searchValue, categoryId);
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

    @GetMapping("/ExportProduct")
    public List<Product> exportProducts(
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "false") boolean random
    ) {
        return productService.exportProducts(quantity, categoryId, random);
    }

}
