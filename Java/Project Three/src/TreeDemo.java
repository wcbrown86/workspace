//Driver file for project 3
//ITCS 2214 -- Professor Jugan

import java.util.Random;

public class TreeDemo {

	public static void main(String[] args){
		
		//Library of words to be added to the tree.
		String[] words = {"Amok", "Nirvana", "Levin", "Minotaur", "Naif", "Brevet", "Dehort", "Costive", 
				"Boffin", "Hoyle", "Scion", "Pissoir", "Looby", "Kvell", "Redact", "Pi"};
		
		//For easier reading swap words for numbers.
		String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "9", "10", "11", "12", "13",
				"14", "15", "16"};
		
		Random rand = new Random();  //Initialize Random
		BinarySerachTree myTree = new BinarySerachTree(); //Initialize the tree
		
		for(int addLoop = 0; addLoop < 30; addLoop++){  //Loop to add items to the Tree
			
			int r = rand.nextInt(16);
			System.out.println("Adding: " + words[r]);
			myTree.insert(words[r]); //Method call to the tree to insert nodes
			
		}
		
		System.out.println("---Searches---"); //Start multiple searches
		myTree.search(words[rand.nextInt(16)]);
		myTree.search(words[rand.nextInt(16)]);
		myTree.search(words[rand.nextInt(16)]);
		
		System.out.println("---Printing---"); //Print the tree using all 
		myTree.printPreOrder();
		myTree.printInOrder();
		myTree.printPostOrder();
	}
}
