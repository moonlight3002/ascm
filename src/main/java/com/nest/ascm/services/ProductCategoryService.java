package com.nest.ascm.services;

import java.util.List;

import com.nest.ascm.models.ProductCategory;

public interface ProductCategoryService {

	public abstract ProductCategory createCategory(ProductCategory category);

	public abstract void updateCategory(ProductCategory category);

	public abstract List<ProductCategory> getCategories();
}
