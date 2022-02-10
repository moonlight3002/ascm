package com.nest.ascm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nest.ascm.dto.InventoryDto;
import com.nest.ascm.globals.Routes;
import com.nest.ascm.services.InventoryService;
import com.nest.ascm.services.ProductService;
import com.nest.ascm.services.WarehouseService;
import com.nest.ascm.utility.GlobalResponse;
import com.nest.ascm.utility.Response;

@RestController
@RequestMapping(Routes.API + Routes.INVENTORY)
public class InventoryController {
	@Autowired
	InventoryService inventoryService;
	
	@Autowired
	WarehouseService WarehouseService;
	
	@Autowired
	ProductService ProductService;
	
	@GetMapping
	public ResponseEntity<Response> getAll() {
		return GlobalResponse.resSuccess(inventoryService.getInventories());
	}
	
	@PostMapping
	public ResponseEntity<Response> create(@RequestBody InventoryDto dto) {
		dto.setProduct(ProductService.getProductbyId(dto.getProduct().getId()));
		dto.setWarehouse(WarehouseService.getWarehousebyId(dto.getWarehouse().getWarehouseId()));
//		System.out.println(dto);
		dto = inventoryService.createInventory(dto);
		
		return GlobalResponse.resSuccess(dto);
	}
	
	@PutMapping
	public ResponseEntity<Response> update(@RequestBody InventoryDto dto) {
		inventoryService.updateInventory(dto);
		return GlobalResponse.resSuccess();
	}
}
