package com.nest.ascm.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nest.ascm.models.Inventory;
import com.nest.ascm.models.InventoryId;

public interface InventoryRepository extends CrudRepository<Inventory, InventoryId> {

	Optional<Inventory> findById(InventoryId inventoryId);
	
}
