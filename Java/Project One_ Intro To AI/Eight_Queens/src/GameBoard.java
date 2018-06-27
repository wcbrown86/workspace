import java.util.Random;

public class GameBoard {
	
	private int huristic, gameSize;
	private int[] currentState;
	
	public GameBoard(int size){
		
		currentState = new int[size];
		gameSize = size;
		
		newBoard(size);
		
	}
	
	public GameBoard(int[] newQueens, int h){
		currentState = newQueens;
		gameSize = currentState.length;
		huristic = h;
	}

	public void newBoard(int size) {
		int[] temp = new int[size];
		
		for(int i = 0; i < size; i++){
			
			Random rand = new Random();
			temp[i] = rand.nextInt(gameSize);

		}
		currentState = temp;
	}
	
	
	public void printBoard(){
		for(int i = 0; i < currentState.length; i++){
			for(int j = 0; j < currentState.length; j++){
				if(currentState[j] == i){
					System.out.print("  1");
				}else{
					System.out.print("  0");
				}
			}
			System.out.println("\n");
		}
	}

	public int getHuristic() {
		return huristic;
	}

	public void setHuristic(int huristic) {
		this.huristic = huristic;
	}
	
	public int[] getQueens(){
		return currentState;
	}

}
