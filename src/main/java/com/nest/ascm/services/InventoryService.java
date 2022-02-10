package com.nest.ascm.services;

import java.util.List;

import com.nest.ascm.dto.InventoryDto;

public interface InventoryService {
	public abstract InventoryDto createInventory(InventoryDto inventory);

	public abstract void updateInventory(InventoryDto inventory);

	public abstract List<InventoryDto> getInventories();
}
