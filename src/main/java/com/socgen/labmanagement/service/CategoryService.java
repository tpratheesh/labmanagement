package com.socgen.labmanagement.service;

import com.socgen.labmanagement.modal.Category;
import com.socgen.labmanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    public Category getCategory(Long id) {
        return this.categoryRepository.findById(id)
                .orElse(null);
    }

    public void createCategory(Category category) {
        if (this.getCategory(category.getId()) != null) {
            throw new RuntimeException("Category exists!");
        }
        this.categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        if (this.getCategory(category.getId()) == null) {
            throw new RuntimeException("Category does not exist!");
        }
        this.categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        if (this.getCategory(id) == null) {
            throw new RuntimeException("Category does not exist!");
        }
        this.categoryRepository.deleteById(id);
    }
}
