package com.nest.ascm.dto;

import com.nest.ascm.models.ProductCategory;

import lombok.Data;

@Data
public class ProductCategoryDto {
	private Long categoryId;
	
	private String categoryName;
	
	public static ProductCategoryDto mappingToDto(ProductCategory cat) {
		ProductCategoryDto categoryDto = new ProductCategoryDto();
		categoryDto.setCategoryId(cat.getCategoryId());
		categoryDto.setCategoryName(cat.getCategoryName());
		return categoryDto;
	}
	
	public static ProductCategory mapping(ProductCategoryDto dto) {
		ProductCategory cat = new ProductCategory();
		cat.setCategoryId(dto.getCategoryId());
		cat.setCategoryName(dto.getCategoryName());
		return cat;
	}

}
