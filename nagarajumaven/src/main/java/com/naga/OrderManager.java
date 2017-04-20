package com.naga;

import java.math.BigDecimal;
import java.util.List;

public class OrderManager {

	public BigDecimal getBill(List<Menu> menulist){
		if(menulist==null){
			return BigDecimal.ZERO;
		}
		BigDecimal bill=BigDecimal.ZERO;
		for(Menu menu:menulist){
			bill=bill.add(menu.getPrice());
		}
		return bill;
	}
}
