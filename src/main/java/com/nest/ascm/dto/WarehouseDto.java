package com.nest.ascm.dto;

import com.nest.ascm.models.Warehouse;

import lombok.Data;

@Data
public class WarehouseDto {
	private Long warehouseId;
	
	private String warehouseName;
	
	private String warehouseLocation;
	
	public static WarehouseDto mappingToDto(Warehouse warehouse) {
		WarehouseDto dto = new WarehouseDto();
		dto.setWarehouseId(warehouse.getWarehouseId());
		dto.setWarehouseName(warehouse.getWarehouseName());
		dto.setWarehouseLocation(warehouse.getWarehouseLocation());
		return dto;
	}
	
	public static Warehouse mapping(WarehouseDto dto) {
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(dto.getWarehouseId());
		warehouse.setWarehouseName(dto.getWarehouseName());
		warehouse.setWarehouseLocation(dto.getWarehouseLocation());
		return warehouse;
	}
}
