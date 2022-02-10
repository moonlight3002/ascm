package com.nest.ascm.services;

import java.util.List;

import com.nest.ascm.dto.WarehouseDto;
import com.nest.ascm.models.Warehouse;

public interface WarehouseService {
	public abstract Warehouse createWarehouse(Warehouse warehouse);

	public abstract void updateWarehouse(Warehouse warehouse);

	public abstract List<Warehouse> getWarehouse();

	public abstract WarehouseDto getWarehousebyId(Long warehouseId);
}
