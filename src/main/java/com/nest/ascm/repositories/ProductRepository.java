package com.nest.ascm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nest.ascm.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByIsShowTrue();

}
