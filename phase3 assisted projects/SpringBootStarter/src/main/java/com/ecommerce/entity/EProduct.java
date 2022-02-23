package com.ecommerce.entity;

import java.math.BigDecimal;


public class EProduct {

	
    private long ID;
    private String name;
    private BigDecimal price;

    public EProduct() {
        
    }

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    
}
