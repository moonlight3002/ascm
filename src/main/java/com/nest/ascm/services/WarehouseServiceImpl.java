package com.nest.ascm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nest.ascm.dto.WarehouseDto;
import com.nest.ascm.exceptions.DataNotFoundException;
import com.nest.ascm.models.Warehouse;
import com.nest.ascm.repositories.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService{
	
	@Autowired
	WarehouseRepository warehouseRepo;

	@Override
	public Warehouse createWarehouse(Warehouse warehouse) {
		warehouse = warehouseRepo.save(warehouse);
		return warehouse;
	}

	@Override
	public void updateWarehouse(Warehouse warehouse) {
		Optional<Warehouse> op = warehouseRepo.findById(warehouse.getWarehouseId());
		if (op.isPresent()) {
			try {
				warehouseRepo.save(warehouse);
			} catch (DataIntegrityViolationException e) {
				throw new DataNotFoundException();
			}
		} else {
			throw new DataNotFoundException();
		}
	}

	@Override
	public List<Warehouse> getWarehouse() {
		List<Warehouse> warehouses = new ArrayList<>();
		warehouseRepo.findAll().forEach(warehouses::add);
		return warehouses;
	}

	@Override
	public WarehouseDto getWarehousebyId(Long warehouseId) {
		
		Optional<Warehouse> op = warehouseRepo.findById(warehouseId);
		if(op.isPresent()) {
			return WarehouseDto.mappingToDto(op.get());
		}else {
			throw new DataNotFoundException();
		}
		
	}
	
}
