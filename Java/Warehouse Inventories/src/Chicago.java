
public class Chicago extends Inventory{
	
	
	public Chicago() {
		super();
	}
	
	//sets the inventory of the parts
	public Chicago(int i102, int i215, int i410, int i525, int i711){
		
		item102 = i102;
		item215 = i215;
		item410 = i410;
		item525 = i525;
		item711 = i711;
	}

	//Prints the warehouse name and calls the inventory print method
	public void printInventory() {
		
		System.out.println("Warehouse: Chicago");
		super.printInventory();
		
	}
}
