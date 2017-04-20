package com.naga;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MenuTest {
	private OrderManager orderManager;

	@Before
	public void setup() {
		orderManager = new OrderManager();
	}

	@Test
	public void purchaseTest() {
		List<Menu> menulist = Arrays.asList(Menu.COLA, Menu.COFFEE, Menu.CHINESE_SANDWICH);
		BigDecimal bill = orderManager.getBill(menulist);
		assertTrue(bill.equals(BigDecimal.valueOf(3.5)));
	}
}
