package com.monotonic.testing.m2.TestingInJavaIntroduction;

import org.junit.Test;

import org.junit.Assert;

public class CafeTest {
	
	@Test
	 public void canBrewEspresso() {
		 
		 // Given
		 Cafe cafe = new Cafe();
		 cafe.restockBeans(7);
		 
		 // When
		 Coffee coffee = cafe.brew(CoffeeType.Espresso);
		 
		 // Then
		 Assert.assertEquals(CoffeeType.Espresso, coffee.getType());
		 Assert.assertEquals(0, coffee.getMilk());
		 Assert.assertEquals(7,  coffee.getBeans());
		 
	 }
	
	@Test
	public void brewingEspressoConsumesBeans() {
		
		// Given
		Cafe cafe = new Cafe();
		cafe.restockBeans(7);
		
		// When
		Coffee coffee = cafe.brew(CoffeeType.Espresso);
		
		// Then
		Assert.assertEquals(0,  cafe.getBeansInStock());
	}
	
	// Then
	@Test(expected = IllegalStateException.class)
	public void lattesRequiresMilk() {
		
		// given
		Cafe cafe = new Cafe();
		cafe.restockBeans(7);
		
		// when 
		cafe.brew(CoffeeType.Latte);
		
	}

}
