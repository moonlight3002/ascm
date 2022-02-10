package com.nest.ascm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nest.ascm.exceptions.CustomDataIntegrityException;
import com.nest.ascm.exceptions.DataNotFoundException;
import com.nest.ascm.models.ProductCategory;
import com.nest.ascm.repositories.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	ProductCategoryRepository categoryRepo;

	@Override
	public ProductCategory createCategory(ProductCategory category) {
		try {
			category = categoryRepo.save(category);
			return category;
		} catch (DataIntegrityViolationException e) {
			throw new CustomDataIntegrityException("category already exist");
		}
	}

	@Override
	public void updateCategory(ProductCategory category) {
		Optional<ProductCategory> op = categoryRepo.findById(category.getCategoryId());
		if (op.isPresent()) {
			try {
				categoryRepo.save(category);
			} catch (DataIntegrityViolationException e) {
				throw new DataNotFoundException();
			}
		} else {
			throw new DataNotFoundException();
		}
	}

	@Override
	public List<ProductCategory> getCategories() {
		List<ProductCategory> categories = new ArrayList<>();
		categoryRepo.findAll().forEach(categories::add);
		return categories;
	}

}
