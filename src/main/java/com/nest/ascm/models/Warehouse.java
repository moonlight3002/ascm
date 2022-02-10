package com.nest.ascm.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="warehouse")
public class Warehouse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="warehouse_id")
	private Long warehouseId;
	
	private String warehouseName;
	
	private String warehouseLocation;
	
	@OneToMany(mappedBy = "warehouse")
    private Set<Inventory> inventories;
	
}
