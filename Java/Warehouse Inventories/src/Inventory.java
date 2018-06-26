
public abstract class Inventory {
	//Defines the set parts numbers for each warehouse
	public int item102, item215, item410, item525, item711;
	
	//sets all to zero
	public Inventory() {
		item102 = 0;
		item215 = 0;
		item410 = 0;
		item525 = 0;
		item711 = 0;
	}
	
	//changes the part inventory from a sell
	public void sellItem(int inventory, int amount){
		
		switch(inventory){
		case 102:
			item102 -= amount;
			break;
		case 215:
			item215 -= amount;
			break;
		case 410:
			item410 -= amount;
			break;
		case 525:
			item525 -= amount;
			break;
		case 711:
			item711 -= amount;
			break;
		default:
			break;
		}
		
	}
	
	//changes the part inventory from a purchase 
	public void purchaseItem(int inventory, int amount){
		
		switch(inventory){
		case 102:
			item102 += amount;
			break;
		case 215:
			item215 += amount;
			break;
		case 410:
			item410 += amount;
			break;
		case 525:
			item525 += amount;
			break;
		case 711:
			item711 += amount;
			break;
		default:
			break;
		}
		
	}
	
	//Returns the inventory of a select part.
	public int getItem(int inventory){
		
		switch(inventory){
		case 102:
			return item102;
		case 215:
			return item215;
		case 410:
			return item410;
		case 525:
			return item525;
		case 711:
			return item711;
		default:
			return 0;
		}
		
	}
	
	//Prints the inventory of all the parts.
	public void printInventory(){
		
		System.out.println("   Items: 102: " + item102);
		System.out.println("   Items: 215: " + item215);
		System.out.println("   Items: 410: " + item410);
		System.out.println("   Items: 525: " + item525);
		System.out.println("   Items: 711: " + item711);
	}
}
