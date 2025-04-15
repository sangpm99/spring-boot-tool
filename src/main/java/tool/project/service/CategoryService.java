package tool.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tool.project.hellper.formatter;
import tool.project.model.Category;
import tool.project.repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Map<String, Object> getCategories(int pageIndex, int pageSize, String searchValue) {
        int offset = (pageIndex - 1) * pageSize;

        List<Category> items;
        int itemsCount;

        if (searchValue != null && !searchValue.isEmpty()) {
            items = categoryRepository.searchCategories(searchValue, pageSize, offset);
            itemsCount = categoryRepository.countSearchCategories(searchValue);
        } else {
            items = categoryRepository.getAllCategories(pageSize, offset);
            itemsCount = categoryRepository.countAllCategories();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("pageIndex", pageIndex);
        result.put("pageSize", pageSize);
        result.put("itemsCount", itemsCount);
        result.put("items", items);

        return result;
    }


    public void createCategory (Category category) {
        String slug = formatter.toSlug(category.getName());
        categoryRepository.insertCategory(category.getName(), slug);
    }

    public void updateCategory(Category category) {
        String slug = formatter.toSlug(category.getName());
        categoryRepository.updateCategory(category.getId(), category.getName(), slug);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteCategoryById(id);
    }
}
