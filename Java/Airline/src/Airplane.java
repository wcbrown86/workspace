/**
 * 
 * @author William Chad Brown
 * 
 * Details:	This class is used to maintain the status of the seats for the current
 * 			Airplane. When an instance of this class is created a plane of 20 rows 
 * 			is created will the first five rows being first class seats, where only 
 * 			two seats are on each side. The remaining 15 rows, will be classified as 
 * 			economy. These will have three seats on each side. 
 * 
 * TODO: 	1. Re-factor findSeatsEconomy to be similar to findSeatsFirst. This function
 * 			   contains repeated code that can be simplified and made reusable. 
 *
 */
public class Airplane {
	
	
	// Global variables. SEAT is the width of the plane, and contains space for the row label
	// and the center aisle in the plane, seating array contains the information about each 
	// seat. 
	public static final int SEAT = 8;
	public static final int ROW = 20;
	public Seating seating[][] = new Seating[SEAT][ROW];

	/**
	 * Airplane constructor, this sets up the planes seating chart. All seats
	 * are set up as open. The constructor for Seating will create the plane with
	 * the aisles and row numbers. 
	 */
	public Airplane(){
		
		for(int i = 0; i < SEAT; i++){
			for(int j = 0; j < ROW; j++){
				seating[i][j] = new Seating(j,i);
			}
		}
		
	}
	
	/**
	 * The getSeat function returns the string that represents the seat letter in the row. the range is 
	 * A-F. 
	 * 
	 * @param i - an integer that points to the row that the seat is in, in the array. 
	 * @param j - an integer that points to the column that the seat is in, in the array.
	 * @return - a string that represents the seat location in the row(ex. A).
	 */
	public String getSeat(int i, int j){
		
		return seating[i][j].getVisual();
	}
	
	/**
	 * This function takes two parameters and then locates open seats that fit the users selection.
	 * the program will not split up passengers that are traveling together. If the user is looking
	 * for more than one seat at a time the program will look for that amount of seats that are together
	 * on the same row and on the same side of the plane. 
	 * 
	 * @param passengers - The number of passengers that are traveling together. for first class
	 * 					   this will be 0 > x < 4
	 * 
	 * @param seating2 - Is a string that identifies if the seat will be a window, middle, or aisle 
	 * 				 	 seat. 
	 * 
	 * @return - A string containing the location information about the seat/s. If three passengers 
	 * 			are traveling together then the location of the seat will not matter due to the program
	 * 			will not split up the passengers that are traveling together. If no seats are found, the 
	 * 			return message will read 'No seats found.'.
	 * 
	 * TODO: Need to re-factor this function to reduce the amount of reused code. 
	 */
	public String findSeatsEconomy(int passengers, String seating2) {
		String message = "No seat found. ";
		
		switch(seating2.toLowerCase()){
		case "window":
			if(passengers == 1){
				for(int i = 0; i < 5; i++){
					for(int j = 0; j < ROW && j < 15; j++){
						if(seating[i][j].getPosition() == 'W' && !seating[i][j].getStatus()){
							message = "Seat found. " + (20 - j) + seating[i][j].getVisual();
							seating[i][j].setStatusFilled();
							return message;

						}
					}
				}
			}
			else if(passengers == 2){
				for(int i = 1; i < SEAT; i++){
					for(int j = 0; j < ROW && j < 15; j++){
						switch(i){
						case 1:
							if(!seating[i][j].getStatus() && !seating[i + 1][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + "and seat "  +  (20 - j) + seating[i + 1][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i + 1][j].setStatusFilled();
								return message;
							}
							break;
						case 7:
							if(!seating[i][j].getStatus() && !seating[i - 1][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + "and seat "  +  (20 - j) + seating[i - 1][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i - 1][j].setStatusFilled();
								return message;
							} 
							break;
						default:
							break;
						}
					}
				}
			}
			else if(passengers == 3){
				for(int i = 1; i < SEAT; i++){
					for(int j = 0; j < ROW && j < 15; j++){
						switch(i){
						case 1:
							if(!seating[i][j].getStatus() && !seating[i + 1][j].getStatus() && !seating[i + 2][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + ", "  +  (20 - j) + seating[i + 1][j].getVisual() + ", "  
									+  (20 - j) + seating[i + 2][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i + 1][j].setStatusFilled();
								seating[i + 2][j].setStatusFilled();
								return message;
							}
							break;
						case 7:
							if(!seating[i][j].getStatus() && !seating[i - 1][j].getStatus() && !seating[i - 2][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + ", "  +  (20 - j) + seating[i - 1][j].getVisual() + ", "  
									+  (20 - j) + seating[i - 2][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i - 2][j].setStatusFilled();
								seating[i - 1][j].setStatusFilled();
								return message;
							}
							break;
						default:
							break;
						}
					}
				}
			}
			break;
		case "middle":
			if(passengers == 1){
				for(int i = 0; i < SEAT; i++){
					for(int j = 0; j < ROW && j < 15; j++){
						if(seating[i][j].getPosition() == 'M' && !seating[i][j].getStatus()){
							message = "Seat found. " + (20 - j) + seating[i][j].getVisual();
							seating[i][j].setStatusFilled();
							return message;

						}
					}
				}
			}
			else if(passengers == 2){
				for(int i = 1; i < SEAT; i++){
					for(int j = 0; j < ROW && j < 15; j++){
						switch(i){
						case 2: case 6:
							if(!seating[i][j].getStatus() && !seating[i + 1][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + "and seat "  +  (20 - j) + seating[i + 1][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i + 1][j].setStatusFilled();
								return message;
							}
							else if(!seating[i][j].getStatus() && !seating[i - 1][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + "and seat "  +  (20 - j) + seating[i - 1][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i - 1][j].setStatusFilled();
								return message;
							}
							break;
						default:
							break;
						}
					}
				}
			}
			else if(passengers == 3){
				for(int i = 1; i < SEAT; i++){
					for(int j = 0; j < ROW && j < 15; j++){
						switch(i){
						case 2: case 6:
							if(!seating[i][j].getStatus() && !seating[i + 1][j].getStatus() && !seating[i - 1][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + ", "  +  (20 - j) + seating[i + 1][j].getVisual() + ", "  
									+  (20 - j) + seating[i - 1][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i + 1][j].setStatusFilled();
								seating[i - 1][j].setStatusFilled();
								return message;
							}
							break;
						default:
							break;
						}
					}
				}
			}
			break;
		case "aisle":
			if(passengers == 1)
				for(int i = 0; i < SEAT; i++){
					for(int j = 0; j < ROW && j < 15; j++){
						if(seating[i][j].getPosition() == 'A' && !seating[i][j].getStatus()){
							message = "Seat found. " + (20 - j) + seating[i][j].getVisual();
							seating[i][j].setStatusFilled();
							return message;
						}
					}
				}
			else if(passengers == 2){
				for(int i = 1; i < SEAT; i++){
					for(int j = 0; j < ROW && j < 15; j++){
						switch(i){
						case 3:
							if(!seating[i][j].getStatus() && !seating[i - 1][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + "and seat "  +  (20 - j) + seating[i - 1][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i - 1][j].setStatusFilled();
								return message;
							} 
							break;
						case 5:
							if(!seating[i][j].getStatus() && !seating[i + 1][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + "and seat "  +  (20 - j) + seating[i + 1][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i + 1][j].setStatusFilled();
								return message;
							}
							break;
						default:
							break;
						}
					}
				}
			}
			else if(passengers == 3){
				for(int i = 1; i < SEAT; i++){
					for(int j = 0; j < ROW && j < 15; j++){
						switch(i){
						case 3:
							if(!seating[i][j].getStatus() && !seating[i - 1][j].getStatus() && !seating[i - 2][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + ", "  +  (20 - j) + seating[i - 1][j].getVisual() + ", "  
									+  (20 - j) + seating[i - 2][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i - 2][j].setStatusFilled();
								seating[i - 1][j].setStatusFilled();
								return message;
							}
							break;
						case 5:
							if(!seating[i][j].getStatus() && !seating[i + 1][j].getStatus() && !seating[i + 2][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + ", "  +  (20 - j) + seating[i + 1][j].getVisual() + ", "  
									+  (20 - j) + seating[i + 2][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i + 1][j].setStatusFilled();
								seating[i + 2][j].setStatusFilled();
								return message;
							}
							break;
						default:
							break;
						}
					}
				}
			}
			break;
		default:
			message = "Incorrect Seat option picked.";
			break;		
		}
		
		return message;
	}
	
	
	/**
	 * This function takes two parameters that is needed to locate a seat of the users selection. The program
	 * will not split up passengers that are traveling together. So even if two seats are open, if they are not 
	 * together the program will return no seats found. 
	 * 
	 * @param numPassengers - The number of passengers that are traveling together. for first class
	 * 						  this will be 0 > x < 3.
	 * 
	 * @param seatType	- This a char that identifies if the seat will be a window or aisle seat.
	 *  
	 * @return - A string containing the location information about the seat/s. If two passengers 
	 * 			are traveling together then the location of the seat will not matter due to the program
	 * 			will not split up the passengers that are traveling together. If no seats are found, the 
	 * 			return message will read 'No seats found.'. 
	 */
	public String findSeatsFirst(int numPassengers, char seatType) {
		// Local variables. message is the return variable that is used to send the seat
		// information to the calling function. Diff is used to allow single seats be filled 
		// from the back to the front. 
		String message = "No seat found. ";
		int diff = 2;

		
		// If the seat type is W then the next W seat is 3 indexes from than the first one on
		// the same row, and 2 otherwise. 
		if(seatType == 'W')
			diff = 3;
		
		
		// Logic for finding open seats. The logic is different for 1 passenger vs. two passengers. 
		if(numPassengers == 1){
			
			// The program loops through each column, looking at each row in the column. It checks to see
			// if the seat is the correct location (window or aisle) and that the seat is open. 
			for(int i = 15; i < ROW; i++){
				for(int j = 2; j <= 3; j++){
					// Checks the first seat in the column the 'A' location, if it is open the status is set to full and the 
					// seat location information is passed back to the user with the return message. 
					if(seating[j][i].getPosition() == seatType && !seating[j][i].getStatus()){
						message = "Seat found. " + (20 - i) + seating[j][i].getVisual();
						seating[j][i].setStatusFilled();
						return message;
					// Checks the second see of the same type to see if the seat is open. If the seat is open then the seat
					// status is set to full, and the seat location information is passed back to the user. 
					} else if (seating[j + diff][i].getPosition() == seatType && !seating[j + diff][i].getStatus()) {
						message = "Seat found. " + (20 - i) + seating[j + diff][i].getVisual();
						seating[j + diff][i].setStatusFilled();
						return message;
					}
				}
			}
		// If the user is looking for two passenger the program loops looking for two open seat that 
		// are in the same column and on the same side of the plane. The program will not split up
		// the passengers. 
		} else if(numPassengers == 2){
			for(int i = 15; i < ROW; i++){
				for(int j = 2; j <= 3; j++){
					// Checks the right side of the plane(seats A and B) for open seats. If an open
					// seat is found then the status is changed to full and the location information is 
					// returned to the user. 
					if(!seating[j][i].getStatus() && !seating[j + 1][i].getStatus()){
						message = "Seat found. " + (20 - i) +seating[j][i].getVisual() + "and seat "  +  (20 - i) + seating[j + 1][i].getVisual();
						seating[j][i].setStatusFilled();
						seating[j + 1][i].setStatusFilled();
						return message;
					// Checks the left side of the plane(C and D) for open seats. If an open seat
					// if found then the status is changed to full and the location information is
						// returned to the user. 
					} else if (!seating[j + diff][i].getStatus() && !seating[j + diff + 1][i].getStatus()){
						message = "Seat found. " + (20 - i) +seating[j + diff][i].getVisual() + "and seat "  +  (20 - i) + seating[j + diff + 1][i].getVisual();
						seating[j + diff][i].setStatusFilled();
						seating[j + diff + 1][i].setStatusFilled();
						return message;
					}
				}
			}
		}
	
		return message;
	}
}
