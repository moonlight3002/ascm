package com.nest.ascm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nest.ascm.models.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {
	
	public abstract List<Brand> findByIsActiveTrue();
}
