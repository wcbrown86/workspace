
public class AnswerHistory {
	
	private int numbOne;
	private int numbTwo;
	private int optionSelected;
	private int userAnswer;
	private String userCorrect;

	public AnswerHistory(int x, int y, int option, int answer, boolean isCorrect){
		
		numbOne = x;
		numbTwo = y;
		optionSelected = option;
		userAnswer = answer;
		
		if(isCorrect)
			userCorrect = "Correct!!";
		else
			userCorrect = "Incorrect!!";
	}

	public String toString(){
		
		switch(optionSelected){
		case 0:
			return numbOne + " + " + numbTwo + " = " + (numbOne+numbTwo) + " Your answer: " + userAnswer + " was: " + userCorrect;

		case 1:
			if(numbOne > numbTwo)
				return numbOne + " - " + numbTwo + " = " + (numbOne-numbTwo) + " Your answer: " + userAnswer + " was: " + userCorrect;
			else
				return numbTwo + " - " + numbOne + " = " + (numbTwo-numbOne) + " Your answer: " + userAnswer + " was: " + userCorrect;
			
		case 2:
			return numbOne + " * " + numbTwo + " = " + (numbOne*numbTwo) + " Your answer: " + userAnswer + " was: " + userCorrect;
			
		case 3:
			if(numbOne > numbTwo)
				return numbOne + " / " + numbTwo + " = " + (numbOne/numbTwo) + " Your answer: " + userAnswer + " was: " + userCorrect;
			else
				return numbTwo + " / " + numbOne + " = " + (numbTwo/numbOne) + " Your answer: " + userAnswer + " was: " + userCorrect;
		default:
			return "Error with selection";
		}
	}
}
