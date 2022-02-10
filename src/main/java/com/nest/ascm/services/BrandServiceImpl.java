package com.nest.ascm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nest.ascm.dto.BrandDto;
import com.nest.ascm.exceptions.DataNotFoundException;
import com.nest.ascm.models.Brand;
import com.nest.ascm.repositories.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService{
	
	@Autowired BrandRepository brandRepository;

	@Override
	public BrandDto createBrand(BrandDto brandDto) {
		Brand brand = BrandDto.mapping(brandDto);
		brand = brandRepository.save(brand);
		brandDto = BrandDto.mappingToDto(brand);
		return brandDto;
	}

	@Override
	public void updateBrand(Long id, BrandDto brandDto) throws DataNotFoundException {
		Optional<Brand> op = brandRepository.findById(id);
		if(op.isPresent()) {
			Brand brand = op.get();
			brand.setBrandName(brandDto.getName());
			brandRepository.save(brand);
		} else {
			throw new DataNotFoundException();
		}
	}

	@Override
	public void deleteBrand(Long id) {
		try {
			brandRepository.deleteById(id);			
		}catch (Exception e) {
			throw new DataNotFoundException();
		}
	}

	@Override
	public List<BrandDto> getBrands() {
		List<Brand> brands = brandRepository.findByIsActiveTrue();
		List<BrandDto> brandsDto = BrandDto.mappingListToDto(brands);
		return brandsDto;
		
	}

}
