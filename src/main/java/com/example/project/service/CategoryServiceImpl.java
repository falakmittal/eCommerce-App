package com.example.project.service;

import com.example.project.model.Category;
import com.example.project.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
    		categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found"));
    		categoryRepository.deleteById(categoryId);
    		return "Category with categoryId: " + categoryId + " deleted successfully!!!";
    }

    @Override
	public Category updateCategory(Category category, Long categoryId) {

		Category savedCategory = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found"));
		savedCategory.setCategoryName(category.getCategoryName());
		savedCategory = categoryRepository.save(savedCategory);
		return savedCategory;
	}
}
