import java.util.ArrayList;

public class Main {
	
	 

	public static void main(String[] args) {
		
		GameBoard board= new GameBoard(8);
		CheckBoard check = new CheckBoard(board);
		int changes = 0;
		int restart = 0;
		ArrayList<GameBoard> newBoards = new ArrayList<GameBoard>();
		
		board.setHuristic(check.findHuristic());
		
		do{
			
			newBoards.clear();
			
			if(board.getHuristic() == 0){
				System.out.println("Current State");
				board.printBoard();
				System.out.println("Solution Found! \n"
						+ "State Changes: " + changes + "\n"
						+ "Restarts: " + restart);
			}else{
				
				int[] test = board.getQueens();
				
				for(int i = 0; i < test.length; i++){
					int hold = test[i];
					for(int j = 0; j < test.length; j++){
						test[i] = j;
						int h = check.findHuristic(test);
						if(h < board.getHuristic()){
							newBoards.add(new GameBoard(test,h));
						}
					}
					test[i] = hold;
				}
				
				System.out.println("Current h: " + board.getHuristic()
					+ "\nCurrent State");
				board.printBoard();
				
				if(newBoards.isEmpty()){
					System.out.println("Neighbors found with lower h: 0 \n"
							+ "RESTART\n\n");
					restart++;
					board.newBoard(8);
					board.setHuristic(check.findHuristic(board.getQueens()));
				}else{
					
					System.out.println("Neighbors found with lower h: " + newBoards.size() 
						+ "\nSetting new current state\n\n");
					int min = newBoards.get(0).getHuristic();
					GameBoard nextBoard = newBoards.get(0);
					for(GameBoard next: newBoards){
						if(min > next.getHuristic()){
							min = next.getHuristic();
							nextBoard = next;
						}
					}
					board = new GameBoard(nextBoard.getQueens(),nextBoard.getHuristic());
					changes++; 
					
				}
			}
			
		}while(board.getHuristic() != 0);
		
		System.out.println("Current State");
		board.printBoard();
		System.out.println("Solution Found! \n"
				+ "State Changes: " + changes + "\n"
				+ "Restarts: " + restart);
		
		
		
		

	}

}
