package tool.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tool.project.service.CategoryService;
import tool.project.model.Category;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/GetCategories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/CreateCategory")
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }
}
