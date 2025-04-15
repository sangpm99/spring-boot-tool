package tool.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tool.project.hellper.formatter;
import tool.project.model.Category;
import tool.project.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.getCategories();
    }

    public void createCategory (Category category) {
        String slug = formatter.toSlug(category.getName());
        categoryRepository.insertCategory(category.getName(), slug);
    }

    public void updateCategory(Category category) {
        String slug = formatter.toSlug(category.getName());
        categoryRepository.updateCategory(category.getId(), category.getName(), slug);
    }
}
