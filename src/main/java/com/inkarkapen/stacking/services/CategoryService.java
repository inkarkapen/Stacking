package com.inkarkapen.stacking.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.inkarkapen.stacking.models.Category;
import com.inkarkapen.stacking.repositories.CategoryRepository;

@Service
public class CategoryService {
	private static CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	public void createCategory(@Valid Category category) {
		categoryRepository.save(category);
	}
	public Category findById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
}
