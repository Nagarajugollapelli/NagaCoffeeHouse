package com.naga;

import java.math.BigDecimal;

public enum Menu {

	COLA("Cola", "Cold", BigDecimal.valueOf(0.5)),
	COFFEE("Coffee","Hot", BigDecimal.ONE),
	CHINESE_SANDWICH("Chinese Sandwich","Cold", BigDecimal.valueOf(2)),
	STEAK_SANDWICH("Steak Sandwich", "Hot",BigDecimal.valueOf(4.5));
	
	private String name;
	private String type;
	private BigDecimal price;
	private Menu(String name, String type, BigDecimal price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	
}
