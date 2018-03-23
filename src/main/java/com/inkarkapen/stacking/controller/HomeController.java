package com.inkarkapen.stacking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inkarkapen.stacking.models.Category;
import com.inkarkapen.stacking.models.Product;
import com.inkarkapen.stacking.services.CategoryService;
import com.inkarkapen.stacking.services.ProductService;

@Controller
public class HomeController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public HomeController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/")
	public String index() {
		return "stacking.jsp";
	}
	@RequestMapping("/product/new")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		return "newProduct.jsp";
	}
	@PostMapping("/product/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}
	@RequestMapping("/category/new")
	public String addCategory(Model model){
		model.addAttribute("category", new Category());
		return "newCategory.jsp";
	}
	@PostMapping("/category/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
	@RequestMapping("/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("product", productService.findById(id));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("id", id);
		for(Category category: categories) {
			System.out.print(category.getId());
			System.out.print(category.getName());
			
		}
		return "product.jsp";
	}
	@RequestMapping("/category/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", categoryService.findById(id));
		model.addAttribute("products", productService.findAll());
		model.addAttribute("id", id);
		return "category.jsp";
	}
}
