


public class FlashCard 
{
	private String [] question;
	private String[] answer;
	

	
	public FlashCard(String [] quest, String [] answ)
	{
		question = quest;
		answer = answ;
	}
	
	public String getQuestion()
	{
		String quest = "";
		
		for(int i = 0; i < question.length; i++)
		{
			quest += question[i] + "\n";
			if(i == 0)
			{
				quest += "\n";
			}
		}
		return quest;
	}
	
	public String getAnswer()
	{
		String ans = "";
		
		for(int i = 0; i < answer.length; i++)
		{
			ans += answer[i] + "\n";
		}
		return ans;
	}
	
	public void setQuestion(String [] quest)
	{
		question = quest;
	}
	
	public void setAnswer(String[] ans)
	{
		answer = ans;
	}
}
