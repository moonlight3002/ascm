package com.nest.ascm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nest.ascm.dto.ProductDto;
import com.nest.ascm.globals.Routes;
import com.nest.ascm.services.ProductService;
import com.nest.ascm.utility.GlobalResponse;
import com.nest.ascm.utility.Response;

@RestController
@RequestMapping(Routes.API + Routes.PRODUCT)
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<Response> getAll() {
		return GlobalResponse.resSuccess(productService.getProducts());
	}
	
	@PostMapping
	public ResponseEntity<Response> create(@RequestBody ProductDto product) {
		product = productService.createProduct(product);
		return GlobalResponse.resSuccess(product);
	}
	
	@PutMapping
	public ResponseEntity<Response> update(@RequestBody ProductDto product) {
		productService.updateProduct(product);
		return GlobalResponse.resSuccess();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id) {
		productService.deleteProduct(id);
		return GlobalResponse.resSuccess();
	}
}
