package com.nest.ascm.services;

import java.util.List;

import com.nest.ascm.dto.BrandDto;

public interface BrandService {
	public abstract BrandDto createBrand(BrandDto brand);

	public abstract void updateBrand(Long id, BrandDto brand);

	public abstract void deleteBrand(Long id);

	public abstract List<BrandDto> getBrands();
}
