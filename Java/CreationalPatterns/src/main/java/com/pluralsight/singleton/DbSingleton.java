package com.pluralsight.singleton;

public class DbSingleton {
	
	//Makes the class lazily loaded, and volatile makes it thread safe
	private static volatile DbSingleton instance = null;
	
	private DbSingleton() {
		
		if(instance != null) {
			throw new RuntimeException("Use getInstance() method to create");
		}
	}
	
	public static DbSingleton getInstance() {
		
		if(instance == null) {
			
			synchronized(DbSingleton.class) {
				
				if(instance == null) {
					
					instance = new DbSingleton();
				}	
			}
		}
		
		return instance;
	}

}
