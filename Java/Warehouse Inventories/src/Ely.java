
public class Ely extends Inventory{

	public Ely() {
		super();
	}
	
	//sets the inventory of the parts
	public Ely(int i102, int i215, int i410, int i525, int i711){
		
		super(i102, i215, i410, i525, i711);
	}

	//Prints the warehouse name and calls the inventory print method
	public void printInventory() {
		
		System.out.println("Warehouse: Ely");
		super.printInventory();
		
	}
}