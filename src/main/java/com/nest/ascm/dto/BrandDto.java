package com.nest.ascm.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nest.ascm.models.Brand;

import lombok.Data;

@Data
public class BrandDto {
	private long id;
	private String name;
	
	public static BrandDto mappingToDto(Brand brand) {
		BrandDto brandDto = new BrandDto();
		brandDto.setId(brand.getBrandId());
		brandDto.setName(brand.getBrandName());
		return brandDto;
	}
	
	public static Brand mapping(BrandDto dto) {
		Brand brand = new Brand();
		brand.setBrandId(dto.getId());
		brand.setBrandName(dto.getName());
		return brand;
	}

	public static List<BrandDto> mappingListToDto(List<Brand> brands) {
		Stream<Brand> stream = brands.stream();
		List<BrandDto> brandDto = stream.map(brand -> BrandDto.mappingToDto(brand)).collect(Collectors.toList());
		return brandDto;
	}
}
