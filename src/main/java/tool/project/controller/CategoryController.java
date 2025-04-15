package tool.project.controller;

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

import tool.project.service.CategoryService;
import tool.project.model.Category;

@RestController
@RequestMapping("/Category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/GetCategories")
    public Map<String, Object> getCategories(
            @RequestParam(defaultValue = "1") int pageIndex,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(required = false) String searchValue
    ) {
        return categoryService.getCategories(pageIndex, pageSize, searchValue);
    }

    @PostMapping("/CreateCategory")
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }

    @PutMapping("/UpdateCategory/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/DeleteCategory/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
