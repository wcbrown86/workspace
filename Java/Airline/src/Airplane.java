
public class Airplane {
	
	public static final int SEAT = 8;
	public static final int ROW = 20;
	public Seating seating[][] = new Seating[SEAT][ROW];

	//Sets up the seats in the plane and stores in an array.
	public Airplane(){
		
		for(int i = 0; i < SEAT; i++){
			for(int j = 0; j < ROW; j++){
				seating[i][j] = new Seating(j,i);
			}
		}
		
	}
	
	public String getSeat(int i, int j){
		
		return seating[i][j].getVisual();
	}
	
	//Looks for open seats based of the number of passengers and the seat preference. only for economy seats
	public String findSeatsEconomy(int passengers, String seating2) {
		String message = "No seat found. ";
		
		switch(seating2){
		case "window":
			if(passengers == 1){
				for(int i = 0; i < SEAT; i++){
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
	//Looks for open seats based of the number of passengers and the seat preference. only for economy seats
	public String findSeatsFirst(int passengers, String seating2) {
		String message = "No seat found. ";
		switch(seating2){
		case "window":
			if(passengers == 1){
				for(int i = 0; i < SEAT; i++){
					for(int j = 15; j < ROW; j++){
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
						case 2:
							if(!seating[i][j].getStatus() && !seating[i + 1][j].getStatus()){
								message = "Seat found. " + (20 - j) +seating[i][j].getVisual() + "and seat "  +  (20 - j) + seating[i + 1][j].getVisual();
								seating[i][j].setStatusFilled();
								seating[i + 1][j].setStatusFilled();
								return message;
							}
							break;
							
						case 6:
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
			break;
		case "aisle":
			if(passengers == 1){
				for(int i = 0; i < SEAT; i++){
					for(int j = 15; j < ROW; j++){
						if(seating[i][j].getPosition() == 'A' && !seating[i][j].getStatus()){
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
			break;
		default:
			message = "Incorrect Seat option picked.";
			break;		
		}
				
		
		return message;
	}

}
