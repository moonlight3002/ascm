package com.nest.ascm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nest.ascm.dto.InventoryDto;
import com.nest.ascm.exceptions.CustomDataIntegrityException;
import com.nest.ascm.exceptions.DataNotFoundException;
import com.nest.ascm.models.Inventory;
import com.nest.ascm.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepo;
	
	@Override
	public InventoryDto createInventory(InventoryDto inventoryDto) {
		try {
			Inventory inventory = InventoryDto.mapping(inventoryDto);
			System.out.println(inventory);
			inventory = inventoryRepo.save(inventory);
			inventoryDto = InventoryDto.mappingToDto(inventory);
			
			return inventoryDto;
		} catch (DataIntegrityViolationException e) {
			throw new CustomDataIntegrityException();
		}
	}

	@Override
	public void updateInventory(InventoryDto inventoryDto) {
		Optional<Inventory> op = inventoryRepo.findById(inventoryDto.getInventoryId());
		if (op.isPresent()) {
			try {
				inventoryRepo.save(InventoryDto.mapping(inventoryDto));
			} catch (DataIntegrityViolationException e) {
				throw new DataNotFoundException();
			}
		} else {
			throw new DataNotFoundException();
		}
	}

	@Override
	public List<InventoryDto> getInventories() {
		List<Inventory> inventories = new ArrayList<>();
		inventoryRepo.findAll().forEach(inventories::add);
		List<InventoryDto> inventoriesDto = InventoryDto.mappingListToDto(inventories);
		return inventoriesDto;
	}
	
}
