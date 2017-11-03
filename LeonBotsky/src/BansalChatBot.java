//Saurabh Bansal
import java.util.Random;
public class BansalChatBot 
{
	//Emotion can alter the way our bot responds. Depends on your response to Communism.
	int emotion = 0;
	// Get a default greeting
	public String getGreeting()
	{
	return "So I hear you're neutral about Communism. "
			+ "Would you like Information about Mother Russia or would you like to talk about Communism?";
	}
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.length() == 0)
		{
			response =  ("I will not repeat myself!");
			emotion = 1;
		}
		
		// Information codes
		else if ((findKeyword(statement, "information")) >= 0 && ((findKeyword(statement, "about communism")) >= 0))
		{
			System.out.println ("What would you like to know?");
			statement = in.nextLine();
			
			while (!statement.equals("Bye"))
				{
					System.out.println (Information.Info(statement));
					statement = in.nextLine();
				}
		}
		else if ((findKeyword(statement, "talk")) >= 0 && ((findKeyword(statement, "about communism")) >= 0))
		{
			System.out.println ("What would you like to know?");
			statement = in.nextLine();
			
			while (!statement.equals("Bye"))
				{
					System.out.println (CommunismTalk.Talk(statement));
					statement = in.nextLine();
				}
		}	
	}
	private int findKeyword(String statement, String goal,int startPos)
			{
					String phrase = statement.trim().toLowerCase();
					goal = goal.toLowerCase();
// The only change to incorporate the startPos is in the line below
			int psn = phrase.indexOf(goal, startPos);
//Making sure the goal isn't part of the word.
			while (psn >= 0)
				{
// Find the string of length 1 before and after the word
					String before = " ", after = " ";
			if (psn > 0)
					{
						before = phrase.substring(psn - 1, psn);
					}
			if (psn + goal.length() < phrase.length())
					{
						after = phrase.substring(psn + goal.length(),psn + goal.length() + 1);
					}
// If before and after aren't letters, we've found the word
			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
// before is not a letter
					{
					return psn;
					}
// The last position didn't work, so let's find the next, if there is one.
					psn = phrase.indexOf(goal, psn + 1);
				}
					return -1;
			}
	private int findKeyword(String statement, String goal)
			{
					return findKeyword (statement, goal, 0);
			}
}
