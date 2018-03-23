package com.inkarkapen.stacking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inkarkapen.stacking.models.Category;


public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
}