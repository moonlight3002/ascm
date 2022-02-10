package com.nest.ascm.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nest.ascm.models.Product;
import com.nest.ascm.models.ProductStatus;
import com.nest.ascm.models.Unit;

import lombok.Data;

@Data
public class ProductDto {
	private Long id;
	
	private String name;
	
	private ProductStatus status=ProductStatus.ACTIVE;
	
	private Unit defaultUnit=Unit.PCS;
	
	private Integer pcsperbox;
	
	private Integer pcsperpack;
	
	private BrandDto brand;
	
	private ProductCategoryDto category;
	
	public static ProductDto mappingToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getProductId());
		productDto.setName(product.getProductName());
		productDto.setStatus(product.getProductStatus());
		productDto.setDefaultUnit(product.getProductDefaultUnit());
		productDto.setPcsperbox(product.getBoxpcs());
		productDto.setPcsperpack(product.getPackpcs());
		productDto.setBrand(BrandDto.mappingToDto(product.getBrand()));
		productDto.setCategory(ProductCategoryDto.mappingToDto(product.getCategory()));
		return productDto;
	}
	
	public static Product mapping(ProductDto dto) {
		Product product = new Product();
		product.setProductId(dto.getId());
		product.setProductName(dto.getName());
		product.setProductStatus(dto.getStatus());
		product.setProductDefaultUnit(dto.getDefaultUnit());
		product.setBoxpcs(dto.getPcsperbox());
		product.setPackpcs(dto.getPcsperpack());
		product.setBrand(BrandDto.mapping(dto.getBrand()));
		product.setCategory(ProductCategoryDto.mapping(dto.getCategory()));
		return product;
	}

	public static List<ProductDto> mappingListToDto(List<Product> products) {
		Stream<Product> stream = products.stream();
		List<ProductDto> productsDto = stream.map(product -> {
			return ProductDto.mappingToDto(product);
		}).collect(Collectors.toList());
		return productsDto;
	}
	
}
