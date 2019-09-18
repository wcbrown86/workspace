package com.monotonic.testing.m2.TestingInJavaIntroduction;

public enum CoffeeType {
	
	Espresso(7, 0),
	Latte(7, 277),
	FilterCoffee(10, 0);
	
	private final int requiredBeans;
	private final int requiredMilk;
	
	CoffeeType(int requiredBeans, int requiredMilk) {
		
		this.requiredBeans = requiredBeans;
		this.requiredMilk = requiredMilk;
		
	}
	
	public int getRequiredBeans() {
		
		return requiredBeans;
		
	}
	
	public int getRequiredMilk() {
		
		return requiredMilk;
		
	}

}
