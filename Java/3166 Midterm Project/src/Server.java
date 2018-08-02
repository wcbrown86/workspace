/*
**	Author: William Chad Brown
**
**  Date: ?
**
** 	Description: 	This Class is the server side of a simple Blackjack game. This
**					game starts both players at a score of 0, and does not take into account
**					the starting deal and unknown card value that is seen in a normal game
**					of Blackjack. Both players use the same screen, and it does not support
**					multiple seesions logging in to play. The point was to of this project
**					was to demonstate knowlage of sockets. 
**
**  TODO:			1. The program does not end, when the game is complete the program does 
**					   does not exit or prompt the user to contine. 
**
**					2. Server needs to show the running score and show the status of the player
**
**					3. Needs to double check formatting and work in a system to clean up the screen.
**
*/

//Imports
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Server {
	
	//Global Variables 
	static int playerOneScore = 0;
	static int playerTwoScore = 0;
	static boolean playerOneStand = false;
	static boolean playerTwoStand = false;
	static Random rand = new Random();
	static String statement;

	public static void main(String[] args) {
		
		
		try {
			
			//Creates the sockets for the server
			ServerSocket serverSocket = new ServerSocket(1050);
			
			//Looks for player One to connect
			Socket playerOne = serverSocket.accept();
			System.out.println("PlayerOne Connected");
			Scanner playerOneInput = new Scanner(playerOne.getInputStream());
			PrintStream playerOneOutput = new PrintStream(playerOne.getOutputStream());
			
			//Looks for player two to connect
			Socket playerTwo = serverSocket.accept();
			System.out.println("PLayerTwo Connected");
			Scanner playerTwoInput = new Scanner(playerTwo.getInputStream());
			PrintStream playerTwoOutput = new PrintStream(playerTwo.getOutputStream());
			
			//Looks for the system to connect
			Socket system = serverSocket.accept();
			System.out.println("System connected");
			PrintStream systemOutput = new PrintStream(system.getOutputStream());
			
			//loops that runs until both player stand if needed
			while(!playerOneStand || !playerTwoStand){
				
				int selection = 0;
				//Waits for player one to enter valid selection
				if(playerOneInput.hasNextInt() && !playerOneStand)
					selection = playerOneInput.nextInt();
				else
					selection = 0;
				
				//Switch statement for player one input if the player is still playing
				switch(selection){
					case 1:
						//adds to the players score based off of the hit method
						playerOneScore += hit();
						//sends new score to the client 
						playerOneOutput.println(playerOneScore);
						break;
					case 2:
						//updates the player stand state
						playerOneStand = true;
						playerOneOutput.println("Player One stands");
						 break;
					default:
						 break;
				}
				
				//Checks to see if the game needs to continue
				if(gameOver()){
					systemOutput.println("exit");
					break;
				}
				else
					systemOutput.println("continue");
				
				//Looks for player two to enter selection if the player is still playing
				if(playerTwoInput.hasNextInt() && !playerOneStand)
					selection = playerTwoInput.nextInt();
				else 
					selection = 0;
				
				//switch for player two
				switch(selection){
				case 1:
					//adds to score based off of the hit method
					playerTwoScore += hit();
					//sends the new score to the player
					playerTwoOutput.println(playerTwoScore);
					break;
				case 2:
					//updates the player stand state
					playerTwoStand = true;
					playerTwoOutput.println("Player Two stands");
					 break;
				default:
					 break;
				}
				
				//checks to see if the game should continue 
				if(gameOver()){
					systemOutput.println("exit");	
				}
				else
					systemOutput.println("continue");
				
			}
			
			//sends the final score to player one
			playerOneOutput.println(playerOneScore);
			//sends the final score to player two
			playerTwoOutput.println(playerTwoScore);
			//Sends the winner to the client 
			systemOutput.println(statement);

			
			//Closes open connections
			serverSocket.close();
			
			playerOne.close();
			playerOneInput.close();
			playerOneOutput.close();
			
			playerTwo.close();
			playerTwoInput.close();
			playerTwoOutput.close();
			
			system.close();
			systemOutput.close();
			
		//Catch for input output error. 	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//Checks the status of the score and game to see if the game is over
	//The statement variable is used to hold the winner information that will be passed
	//to the client later.
	private static boolean gameOver() {
		
		boolean winner = false;
		
		//if either player reaches 21 the game is over
		if(playerOneScore == 21 || playerTwoScore == 21)
			if(playerOneScore ==21){
				statement = "Player One Wins!!";
				return true;
			}
			else{
				statement = "Player Two Wins!!";
				return true;
			}
		//If either player goes over 21 the game is over the player that did not go over 21 wins
		else if(playerOneScore > 21 || playerTwoScore > 21)
			if(playerOneScore > 21){
				statement = "Player Two Wins!!";
				return true;
			}
			else{
				statement = "Player One Wins!!";
				return true;
			}
		//if both players stand the player with the highest score wins
		else if(playerOneStand && playerTwoStand)
			if(playerOneScore > playerTwoScore){
				statement = "Player One Wins!!";
				return true;
			}
			else{
				statement = "Player Two Wins!!";
				return true;
			}
		
		return winner;
	}
	
	//method that produces a random number between 1-13,
	static int hit(){
		//hold the number
		int random = 0;
		//creates the random number
		random = rand.nextInt(12) + 1;
		//if the number is over 10 it is a face card the has the value of 10
		if(random > 10){
			return 10;
		}
		//returns the value if under 10.
		return random;
	}

}
