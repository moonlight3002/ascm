package com.nest.ascm.services;

import java.util.List;

import com.nest.ascm.dto.ProductDto;

public interface ProductService {

	public abstract ProductDto createProduct(ProductDto product);

	public abstract void updateProduct(ProductDto product);
	
	public abstract void deleteProduct(Long id);

	public abstract List<ProductDto> getProducts();

	public abstract ProductDto getProductbyId(Long productId);
}