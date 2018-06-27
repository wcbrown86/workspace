

public class CheckBoard {
	
	GameBoard game;
	
	public CheckBoard(GameBoard newGame){
		
		this.game = newGame;
	}
	
	public int findHuristic(){
		int huristic = 0;
		int[] queens = game.getQueens();
		
		for(int i = 0; i < queens.length; i++){
			for(int j = (i+1); j < queens.length; j++){
				
				if(queens[i] == queens[j])
					huristic++;
				if(Math.abs(j-i) == Math.abs(queens[j] - queens[i]))
					huristic++;
			}
		}
		
		return huristic;
	}
	
	public int findHuristic(int[] test){
		int huristic = 0;
		int[] queens = test;
		
		for(int i = 0; i < queens.length; i++){
			for(int j = (i+1); j < queens.length; j++){
				
				if(queens[i] == queens[j])
					huristic++;
				if(Math.abs(j-i) == Math.abs(queens[j] - queens[i]))
					huristic++;
			}
		}
		
		return huristic;
	}

}
