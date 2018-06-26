
public class Seating {
	
	public static final String OPENSEAT = "["; 
	public static final String TAKENSEAT =	"[X";
	public static final int ROW = 20;
	int seatNumber;
	public boolean isFull;
	String seating;
	private char position;
	
	//creates the seat, gives it a seat position and letter. sets isFull to false. 
	public Seating(int row, int seat) {
		
		isFull = false;
		
		if(seat == 0){
			if( ROW - row >= 10){
				seating = "" + (ROW - row) + " ";
				position = 'N';
				isFull = true;
			}
			else{
				seating = "" + (ROW - row) + "  ";
				position = 'N';
				isFull = true;
			}
		}
		else if(row < 15){
			
			switch(seat){
				case 1:
					seating = "A  ";
					position = 'W';
					break;
				case 2:
					seating = "B  ";
					position = 'M';
					break;
				case 3:
					seating = "C  ";
					position = 'A';
					break;
				case 5:
					seating = "D  ";
					position = 'A';
					break;
				case 6:
					seating = "E  ";
					position = 'M';
					break;
				case 7:
					seating = "F  ";
					position = 'W';
					break;
				default:
					seating = "   ";
					position = 'N';
					isFull = true;
					break;
			}
		}
		else{
			switch(seat){
				case 2:
					seating = "A  ";
					position = 'W';
					break;
				case 3:
					seating = "B  ";
					position = 'A';
					break;
				case 5:
					seating = "C  ";
					position = 'A';
					break;
				case 6:
					seating = "D  ";
					position = 'W';
					break;
				default:
					seating = "   ";
					position = 'N';
					isFull = true;
					break;
			}
		}
	}


	public String getVisual() {
		//Returns the status of the seat, [X means the seat is filled.
		return seating;
	}
	
	public void setStatusFilled(){
		
		seating = "X  ";
		isFull = true;
	}
	
	public boolean getStatus(){
		
		return isFull;
	}


	public char getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

}
