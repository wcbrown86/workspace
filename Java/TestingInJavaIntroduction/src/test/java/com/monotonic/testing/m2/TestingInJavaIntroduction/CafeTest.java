package com.monotonic.testing.m2.TestingInJavaIntroduction;

import org.junit.Test;
import org.junit.Assert;

public class CafeTest {
	
	public static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
	public static final int NO_MILK = 0;
	public static final int NO_BEANS = 0;
	
	@Test
	 public void canBrewEspresso() {
		 
		// given
		Cafe cafe = cafeWithBeans();
		 
		 // When
		 Coffee coffee = cafe.brew(CoffeeType.Espresso);
		 
		 // Then
		 Assert.assertEquals("Wrong Coffee Type", CoffeeType.Espresso, coffee.getType());
		 Assert.assertEquals("Incorrect amount of milk", NO_MILK, coffee.getMilk());
		 Assert.assertEquals("Incorrect amount of Beans", ESPRESSO_BEANS,  coffee.getBeans());
		 
	 }
	
	@Test
	public void brewingEspressoConsumesBeans() {
		
		// given
		Cafe cafe = cafeWithBeans();
		
		// When
		Coffee coffee = cafe.brew(CoffeeType.Espresso);
		
		// Then
		Assert.assertEquals("Bean Stock was not reduced.", NO_BEANS,  cafe.getBeansInStock());
	}
	
	// Then
	@Test(expected = IllegalStateException.class)
	public void lattesRequiresMilk() {
		
		// given
		Cafe cafe = cafeWithBeans();
		
		// when 
		cafe.brew(CoffeeType.Latte);
		
	}
	
	private Cafe cafeWithBeans() {
		
		Cafe cafe = new Cafe();
		cafe.restockBeans(ESPRESSO_BEANS);
		
		return cafe;
		
	}

}
