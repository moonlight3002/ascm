package com.nest.ascm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nest.ascm.dto.ProductDto;
import com.nest.ascm.exceptions.CustomDataIntegrityException;
import com.nest.ascm.exceptions.DataNotFoundException;
import com.nest.ascm.models.Product;
import com.nest.ascm.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public ProductDto createProduct(ProductDto productDto) {
		try {
			System.out.println(ProductDto.mapping(productDto));
			Product product = productRepo.save(ProductDto.mapping(productDto));
			productDto = ProductDto.mappingToDto(product);
			
			return productDto;
		} catch (DataIntegrityViolationException e) {
			throw new CustomDataIntegrityException(e.getMessage());
		}
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		Optional<Product> op = productRepo.findById(productDto.getId());
		if(op.isPresent()) {
			Product product = ProductDto.mapping(productDto);
			productRepo.save(product);
		} else {
			throw new DataNotFoundException();
		}
	}

	@Override
	public void deleteProduct(Long id) {
		try {
			productRepo.deleteById(id);			
		}catch (Exception e) {
			throw new DataNotFoundException();
		}
	}

	@Override
	public List<ProductDto> getProducts() {
		List<Product> products = productRepo.findByIsShowTrue();
		List<ProductDto> productDto = ProductDto.mappingListToDto(products);
		return productDto;
	}
	
	@Override
	public ProductDto getProductbyId(Long productId) {
		Optional<Product> op = productRepo.findById(productId);
		if(op.isPresent()) {
			return ProductDto.mappingToDto(op.get());
		}else {
			throw new DataNotFoundException();
		}
		
	}

}
