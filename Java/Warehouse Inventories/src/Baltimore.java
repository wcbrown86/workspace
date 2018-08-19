
public class Baltimore extends Inventory{

	public Baltimore() {
		super();
	}
	
	//sets the inventory of the parts
	public Baltimore(int i102, int i215, int i410, int i525, int i711){
		
		super(i102, i215, i410, i525, i711);
	}

	//Prints the warehouse name and calls the inventory print method
	public void printInventory() {
		
		System.out.println("Warehouse: Baltimore");
		super.printInventory();
		
	}

}
