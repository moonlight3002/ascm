package com.nest.ascm.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class InventoryId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "warehouse_id")
	private Long warehouseId;
	
	@Column(name = "product_id")
    private Long productId;
	
	

}
