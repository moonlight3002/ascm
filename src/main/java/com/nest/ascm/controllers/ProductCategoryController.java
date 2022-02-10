package com.nest.ascm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nest.ascm.globals.Routes;
import com.nest.ascm.models.ProductCategory;
import com.nest.ascm.services.ProductCategoryService;
import com.nest.ascm.utility.GlobalResponse;
import com.nest.ascm.utility.Response;

@RestController
@RequestMapping(Routes.API + Routes.PRODUCTCATEGORY)
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<Response> getAll() {
		return GlobalResponse.resSuccess(categoryService.getCategories());
	}
	
	@PostMapping
	public ResponseEntity<Response> create(@RequestBody ProductCategory category) {
		category = categoryService.createCategory(category);
		return GlobalResponse.resSuccess(category);
	}
	
	@PutMapping
	public ResponseEntity<Response> update(@RequestBody ProductCategory category) {
		categoryService.updateCategory(category);
		return GlobalResponse.resSuccess();
	}
}
