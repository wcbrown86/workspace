import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	//global variable for the user input and the converted answer.
	static int userSelection;
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		//Creates the local player score.
		int playerOneScore = 0;
		int playerTwoScore = 0;
		
		try {
			
			//Creates the socket to connect to the server and the scanner for the server.
			//Player One Connection
			Socket playerOne = new Socket("127.0.0.1", 1050);
			System.out.println("Player one connecting");
			Scanner playerOneInput = new Scanner(playerOne.getInputStream());
			PrintStream playerOneOutput = new PrintStream(playerOne.getOutputStream());

			//Player Two Connection
			Socket playerTwo = new Socket("127.0.0.1", 1050);
			System.out.println("Player two connecting");
			Scanner playerTwoInput = new Scanner(playerTwo.getInputStream());
			PrintStream playerTwoOutput = new PrintStream(playerTwo.getOutputStream());
			
			//System connection. to track the state of the game.
			Socket system = new Socket("127.0.0.1", 1050);
			Scanner systemInput = new Scanner(system.getInputStream());
			
			
			do{
				//Prints the current state of the game for player one
				System.out.println("Player One's turn, Current score " + playerOneScore);
				printInstruction();//prints valid moves to the player
				getInput();//gets the players input
				playerOneOutput.println(userSelection);//sends users input to the server
				if(playerOneInput.hasNextInt()){
					playerOneScore = Integer.parseInt(playerOneInput.nextLine());//gets current score
					System.out.println("Player One's Score is " + playerOneScore);//prints to the user
					System.out.println("\n\n\n\n");//Formating 
				}
				
				//checks to see if the game should continue
				if(systemInput.nextLine().equals("exit"))
					break;
				
				//Prints the current state of the game for player two
				System.out.println("Player Two's turn, Current score " + playerTwoScore);
				printInstruction();//Prints valid moves to the player
				getInput();//gets the user input
				playerTwoOutput.println(userSelection);//sends the user input to server
				playerTwoScore = Integer.parseInt(playerTwoInput.nextLine());//gets the current score
				System.out.println("Player Two's Score " + playerTwoScore);//prints the current score
				System.out.println("\n\n\n\n");//Formating
				
			}while(systemInput.nextLine().equals("continue"));
			
			System.out.println("Game Over");
			//Prints player ones final score
			System.out.println("Player One's Score " + playerOneScore);
			//prints player twos final score
			System.out.println("Player Two's Score " + playerTwoScore);
			//Gets the winner from the server.
			System.out.println(systemInput.nextLine());
			
			//Closes server connections
			playerOne.close();
			playerOneInput.close();
			playerOneOutput.close();
			
			playerTwo.close();
			playerTwoInput.close();
			playerTwoOutput.close();

			system.close();
			systemInput.close();
			
		//Catch for to possible exceptions 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Closing out the last scanner
		userInput.close();

		

	}
	
	//Gets the users input and checks that the input is valid
	private static void getInput() {

		//get the users input
		userSelection = userInput.nextInt();
		
		//Loops if the users input is invalid until a valid entry is made
		while(userSelection != 1 && userSelection != 2){
			System.out.println("Selection entered was incorrect");
			printInstruction();
			userSelection = userInput.nextInt();
			
		}
			
		
	}
	
	//Prints the valid options to the user.
	static void printInstruction(){
		
		System.out.println("To hit enter 1, to stand enter 2.");
		
	}

}
