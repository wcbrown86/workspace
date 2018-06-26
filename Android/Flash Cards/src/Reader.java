import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Reader 
{
	
	private Scanner file;
	private ArrayList<FlashCard> card;
	
	public Reader(String fileName)
	{
		try
		{
			file = new Scanner(new FileReader(fileName));
		}
		catch(IOException e)
		{
			System.out.println("Could not open the input file" + file);
			System.exit(0);
		}
	}
	
	public ArrayList<FlashCard> readLines()
	{
		card = new ArrayList<FlashCard>();
		String [] line;
		String question;
		String answer;
		String [] answerArray = {"",""};
		String [] questionArray;
		FlashCard flash;
		String [] noAnswer = {"",""};
		while(file.hasNextLine())
		{
			line = file.nextLine().split("|");
			question = line[0];
			if(line.length > 1)
			{
				answer = line[1];
				line = answer.split("_");
				answerArray = line;
			}
			else
			{
				answerArray = noAnswer; 
			}
			line = question.split("_");
			questionArray = line;
			
			
			flash = new FlashCard(questionArray, answerArray);
			card.add(flash);
		}
		return card;
	}
}
