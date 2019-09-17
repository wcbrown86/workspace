package com.pluralsight.abstractfactory;

public class VisaValidator implements Validator {
	
	@Override
	public boolean isValid(CreditCard creditCard) {
		
		return false;
		
	}

}
