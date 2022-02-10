package com.nest.ascm.models;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Data
@Table(name="inventory")
public class Inventory {
    
	@EmbeddedId
    private InventoryId inventoryId = new InventoryId();
	
	@ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("warehouseId")
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
    
    private Long quantityInPcs=0L;
    
    private String notes;
    
    @CreatedDate
	private Date createdDate;
	
	@LastModifiedDate
	private Date modifiedDate;

	

	
}
