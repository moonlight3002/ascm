package com.nest.ascm.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Entity
@Table(name="brand")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long brandId;
	
	@Column(unique = true, nullable = false)
	private String brandName;
	
	@CreatedDate
	@Column(updatable = false)
	private Date createdDate;
	
	@LastModifiedDate
	@Column(updatable = false)
	private Date modifiedDate;
	
	private Boolean isActive = true;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	private List<Product> products;

}
