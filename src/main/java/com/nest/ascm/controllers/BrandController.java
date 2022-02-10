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

import com.nest.ascm.dto.BrandDto;
import com.nest.ascm.globals.Routes;
import com.nest.ascm.services.BrandService;
import com.nest.ascm.utility.GlobalResponse;
import com.nest.ascm.utility.Response;

@RestController
@RequestMapping(Routes.API + Routes.BRAND)
public class BrandController {
	
	@Autowired
	BrandService brandService;
	
	@GetMapping
	public ResponseEntity<Response> getAll() {
		return GlobalResponse.resSuccess(brandService.getBrands());
	}
	
	@PostMapping
	public ResponseEntity<Response> create(@RequestBody BrandDto brand) {
		brand = brandService.createBrand(brand);
		return GlobalResponse.resSuccess(brand);
	}
	
	@PutMapping
	public ResponseEntity<Response> update(@RequestBody BrandDto brand) {
		brandService.updateBrand(brand.getId(), brand);
		return GlobalResponse.resSuccess();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> delete(@PathVariable Long id) {
		brandService.deleteBrand(id);
		return GlobalResponse.resSuccess();
	}
	
	
}
