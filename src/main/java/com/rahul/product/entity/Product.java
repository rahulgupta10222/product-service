package com.rahul.product.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true)
	private String name;
	
	@ElementCollection
	private Map<Long,BigDecimal> quantity = new HashMap<>();
	
	@ElementCollection
	private Map<Long,BigDecimal> purchasePrice = new HashMap<>();
	
	@ElementCollection
	private Map<Long,BigDecimal> salesPrice = new HashMap<>();
	
	@ElementCollection
	private Set<Long> shopIds = new HashSet<>();

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Map<Long, BigDecimal> getQuantity() {
		return quantity;
	}

	public void setQuantity(Map<Long, BigDecimal> quantity) {
		this.quantity = quantity;
	}

	public Map<Long, BigDecimal> getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Map<Long, BigDecimal> purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Map<Long, BigDecimal> getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Map<Long, BigDecimal> salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Set<Long> getShopIds() {
		return shopIds;
	}

	public void setShopIds(Set<Long> shopIds) {
		this.shopIds = shopIds;
	}

	
	
	
}
