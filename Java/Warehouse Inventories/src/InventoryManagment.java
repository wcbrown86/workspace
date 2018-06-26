import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class InventoryManagment {
	
	//Global array list that stores the warehouses for easy access. 
	static ArrayList<Inventory> warehouses = new ArrayList<Inventory>();


	public static void main(String[] args) {
		
		//Variables that store the file names in case they need to be changed easy to find. 
		String fileNameInv = "Inventory.txt";
		String fileNameTrans = "Transactions.txt";

		
		try{
			//Opens the beginning inventory file then takes each line a splits the information at the 
			//comma and white space
			Scanner fileReader = new Scanner(new File(fileNameInv));
			String[] aStart = fileReader.nextLine().split(",\\s");
			String[] bStart = fileReader.nextLine().split(",\\s");
			String[] cStart = fileReader.nextLine().split(",\\s");
			String[] dStart = fileReader.nextLine().split(",\\s");
			String[] eStart = fileReader.nextLine().split(",\\s");
			String[] fStart = fileReader.nextLine().split(",\\s");
			
			//Adds each warehouse to the array list with the information pulled from the file
			warehouses.add(new Atlanta(Integer.parseInt(aStart[0]),Integer.parseInt(aStart[1]),
					Integer.parseInt(aStart[2]),Integer.parseInt(aStart[3]),Integer.parseInt(aStart[4])));
			
			warehouses.add(new Baltimore(Integer.parseInt(bStart[0]),Integer.parseInt(bStart[1]),
					Integer.parseInt(bStart[2]),Integer.parseInt(bStart[3]),Integer.parseInt(bStart[4])));
			
			warehouses.add(new Chicago(Integer.parseInt(cStart[0]),Integer.parseInt(cStart[1]),
					Integer.parseInt(cStart[2]),Integer.parseInt(cStart[3]),Integer.parseInt(cStart[4])));
			
			warehouses.add(new Denver(Integer.parseInt(dStart[0]),Integer.parseInt(dStart[1]),
					Integer.parseInt(dStart[2]),Integer.parseInt(dStart[3]),Integer.parseInt(dStart[4])));
			
			warehouses.add(new Ely(Integer.parseInt(eStart[0]),Integer.parseInt(eStart[1]),
					Integer.parseInt(eStart[2]),Integer.parseInt(eStart[3]),Integer.parseInt(eStart[4])));
			
			warehouses.add(new Fargo(Integer.parseInt(fStart[0]),Integer.parseInt(fStart[1]),
					Integer.parseInt(fStart[2]),Integer.parseInt(fStart[3]),Integer.parseInt(fStart[4])));

			//Prints the beginning inventory
			for(Inventory inv: warehouses){
				inv.printInventory();
			}
			
			//adds white space for formating 
			System.out.println("\n\n");
			//closes first file. 
			fileReader.close();
			
			//Opens the transaction file 
			fileReader = new Scanner(new File(fileNameTrans));
			//String array to store the information of the transaction
			String[] transaction;
			int warehouse = 0;
			
			//loops threw the transaction calls while the file has more transactions to be made. 
			while(fileReader.hasNextLine()){
				
				//splits the string pulled from the file at the commas and white space. 
				transaction = fileReader.nextLine().split(",\\s");
				
				//if it is a purchase the smallest inventory is found and passed to the sell method 
				if(transaction[0].equals("P")){
					warehouse = findSmallestInventory(Integer.parseInt(transaction[1]));
					warehouses.get(warehouse).purchaseItem(Integer.parseInt(transaction[1]), Integer.parseInt(transaction[2]));
				}
				//If a sell is made the largest inventory is found and the sell method is called. 
				else if(transaction[0].equals("S")){
					warehouse = findLargestInventory(Integer.parseInt(transaction[1]));
					warehouses.get(warehouse).sellItem(Integer.parseInt(transaction[1]),  Integer.parseInt(transaction[2]));
				}
			}
			
			//Prints the inventory at the end of the day
			for(Inventory inv: warehouses){
				inv.printInventory();
			}
			
			//Closes the file
			fileReader.close();
			
		}
		//catches the exception and prints the error to the screen
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	//finds the smallest part number inventory and returns the index of that warehouse
	private static int findSmallestInventory(int partNumber) {
		int min = warehouses.get(0).getItem(partNumber);
		int minElement = 0;
		for(int i = 0; i < warehouses.size(); i++){
			
			if(warehouses.get(i).getItem(partNumber) < min){
				min = warehouses.get(i).getItem(partNumber);
				minElement = i;
			}
				
		}
		return minElement;
	}

	//finds the largest part number incentory and returns the index of that warehouse
	private static int findLargestInventory(int partNumber) {
		int max = 0;
		int maxElement = 0;
		for(int i = 0; i < warehouses.size(); i++){
			
			if(warehouses.get(i).getItem(partNumber) > max){
				max = warehouses.get(i).getItem(partNumber);
				maxElement = i;
			}
				
		}
		return maxElement;
	}

}
