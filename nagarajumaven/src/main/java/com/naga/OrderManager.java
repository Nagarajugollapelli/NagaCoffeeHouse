package com.naga;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class OrderManager {

	public BigDecimal getBill(List<Menu> menulist) {
		if (menulist == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal bill = BigDecimal.ZERO;
		for (Menu menu : menulist) {
			bill = bill.add(menu.getPrice());
		}
		return bill;
	}

	public BigDecimal getBillWithServiceCharge(List<Menu> menulist) {
		if (menulist == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal bill = getBill(menulist);
		boolean anyFoodServiceChargeFlag = false;
		boolean anyHotFoodServiceChargeFlag = false;

		for (Menu menu : menulist) {
			if (Menu.CHINESE_SANDWICH.equals(menu) || Menu.STEAK_SANDWICH.equals(menu)) {
				anyFoodServiceChargeFlag = true;
				if (menu.getType().equals("Hot")) {
					anyHotFoodServiceChargeFlag = true;
				}
			}
		}

		BigDecimal anyHotFoodServiceCharge = BigDecimal.ZERO;
		BigDecimal anyFoodServiceCharge = BigDecimal.ZERO;
		if (anyFoodServiceChargeFlag) {
			anyFoodServiceCharge = bill.multiply(BigDecimal.valueOf(0.1)).setScale(2, RoundingMode.HALF_UP);
		}
		if (anyHotFoodServiceChargeFlag) {
			anyHotFoodServiceCharge = bill.multiply(BigDecimal.valueOf(0.2)).setScale(2, RoundingMode.HALF_UP);
			if (BigDecimal.valueOf(20).compareTo(anyHotFoodServiceCharge) < 0) {
				anyHotFoodServiceCharge = BigDecimal.valueOf(20);
			}
		}
		return bill.add(anyFoodServiceCharge).add(anyHotFoodServiceCharge);
	}
}
