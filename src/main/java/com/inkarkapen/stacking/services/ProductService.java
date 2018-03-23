package com.inkarkapen.stacking.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.inkarkapen.stacking.models.Category;
import com.inkarkapen.stacking.models.Product;
import com.inkarkapen.stacking.repositories.ProductRepository;

@Service
public class ProductService {
	private static ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	public void createProduct(@Valid Product product) {
		productRepository.save(product);
	}
	public Product findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
}
