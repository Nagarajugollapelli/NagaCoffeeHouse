package com.naga;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
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
		assertTrue(bill.compareTo(BigDecimal.valueOf(3.5))==0);
	}

	@Test
	public void purchaseOnlyDrinksTest() {
		List<Menu> menulist = Arrays.asList(Menu.COLA, Menu.COFFEE);
		BigDecimal bill = orderManager.getBillWithServiceCharge(menulist);
		assertTrue(bill.compareTo(BigDecimal.valueOf(1.5))==0);
	}

	@Test
	public void purchaseDrinkColdFoodTest() {
		List<Menu> menulist = Arrays.asList(Menu.COLA, Menu.CHINESE_SANDWICH);
		BigDecimal bill = orderManager.getBillWithServiceCharge(menulist);
		assertTrue(bill.compareTo(BigDecimal.valueOf(2.75))==0);
	}

	@Test
	public void purchaseDrinkColdAndHotFoodTest() {
		List<Menu> menulist = Arrays.asList(Menu.COLA, Menu.CHINESE_SANDWICH, Menu.STEAK_SANDWICH);
		BigDecimal bill = orderManager.getBillWithServiceCharge(menulist);
		assertTrue(bill.compareTo(BigDecimal.valueOf(9.10))==0);
	}

	@Test
	public void purchaseColdAndHotFoodTest() {
		List<Menu> menulist = Arrays.asList(Menu.CHINESE_SANDWICH, Menu.STEAK_SANDWICH);
		BigDecimal bill = orderManager.getBillWithServiceCharge(menulist);
		assertTrue(bill.compareTo(BigDecimal.valueOf(8.45))==0);
	}

	@Test
	public void purchaseColdFoodTest() {
		List<Menu> menulist = Arrays.asList(Menu.CHINESE_SANDWICH);
		BigDecimal bill = orderManager.getBillWithServiceCharge(menulist);
		assertTrue(bill.compareTo(BigDecimal.valueOf(2.20))==0);
	}

	@Test
	public void purchaseHotFoodTest() {
		List<Menu> menulist = Arrays.asList(Menu.STEAK_SANDWICH);
		BigDecimal bill = orderManager.getBillWithServiceCharge(menulist);
		assertTrue(bill.compareTo(BigDecimal.valueOf(5.85))==0);
	}

	@Test
	public void purchaseHotFoodWithMoreThan20ServiceChargeTest() {
		List<Menu> menulist = new ArrayList<Menu>();
		for (int i = 0; i < 30; i++) {
			menulist.add(Menu.STEAK_SANDWICH);
		}
		BigDecimal bill = orderManager.getBillWithServiceCharge(menulist);
		assertTrue(bill.compareTo(BigDecimal.valueOf(168.50))==0);
	}
}
