package com.nest.ascm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nest.ascm.globals.Routes;
import com.nest.ascm.models.Warehouse;
import com.nest.ascm.services.WarehouseService;
import com.nest.ascm.utility.GlobalResponse;
import com.nest.ascm.utility.Response;

@RestController
@RequestMapping(Routes.API + Routes.WAREHOUSE)
public class WarehouseController {
	@Autowired
	WarehouseService warehouseService;
	
	@GetMapping
	public ResponseEntity<Response> getAll() {
		return GlobalResponse.resSuccess(warehouseService.getWarehouse());
	}
	
	@PostMapping
	public ResponseEntity<Response> create(@RequestBody Warehouse warehouse) {
		warehouse = warehouseService.createWarehouse(warehouse);
		return GlobalResponse.resSuccess(warehouse);
	}
	
	@PutMapping
	public ResponseEntity<Response> update(@RequestBody Warehouse warehouse) {
		warehouseService.updateWarehouse(warehouse);
		return GlobalResponse.resSuccess();
	}
	
}
