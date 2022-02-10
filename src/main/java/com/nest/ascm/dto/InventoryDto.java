package com.nest.ascm.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nest.ascm.models.Inventory;
import com.nest.ascm.models.InventoryId;

import lombok.Data;

@Data
public class InventoryDto {
	private InventoryId inventoryId;
	
    private ProductDto product;

    private WarehouseDto warehouse;
    
    private Long quantityInPcs=0L;
    
    private String notes;
    
	public static InventoryDto mappingToDto(Inventory inventory) {
		InventoryDto dto = new InventoryDto();
		dto.setInventoryId(inventory.getInventoryId());
		dto.setProduct(ProductDto.mappingToDto(inventory.getProduct()));
		dto.setWarehouse(WarehouseDto.mappingToDto(inventory.getWarehouse()));
		return dto;
	}
	
	public static Inventory mapping(InventoryDto dto) {
		Inventory inventory = new Inventory();
		inventory.setInventoryId(dto.getInventoryId());
		inventory.setProduct(ProductDto.mapping(dto.getProduct()));
		inventory.setWarehouse(WarehouseDto.mapping(dto.getWarehouse()));
		return inventory;
	}

	public static List<InventoryDto> mappingListToDto(List<Inventory> inventories) {
		Stream<Inventory> stream = inventories.stream();
		List<InventoryDto> inventoriesDto = stream.map(inventory -> InventoryDto.mappingToDto(inventory)).collect(Collectors.toList());
		return inventoriesDto;
	}
}
