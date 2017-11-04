 //Saurabh Bansal
import java.util.Random;

public class CommunismTalk 
{
	int emotion = 0;
	public String talk(String statement)
	{
		String response = "";
		// if and else statments to talk bout communism
		{
			if ((findKeyword(statement, "sucks") >= 0) || (findKeyword(statement, "it's bad")) >= 0 
					|| (findKeyword(statement, "bad") >= 0))
				{
					emotion = 1;
					response = "How come?";
				}
			else if ((findKeyword(statement, "hate") >= 0))
				{
					emotion = -1 ;
					response = "Why?";
				}
			else if ((findKeyword(statement, "best")) >= 0 || (findKeyword(statement, "sexy")) >= 0 
					|| (findKeyword(statement, "Karl Marx is the best!") >= 0))
				{
					response = "I couldn't agree more!";
					emotion = 1;
				}
			else if (findKeyword(statement, "I love to", 0) >= 0)
				{
					response = transformILoveToStatement(statement);
				}
			else if (findKeyword(statement, "I love", 0) >= 0)
				{
					response = transformILoveStatement(statement);
				}
			else
				{
					response = getRandomResponse();
				}
			return response;
		}
	}
//Take an I want statement and the bot would try understanding why one likes __. Emotion can alter it's response.
	private String transformILoveStatement(String statement)
		{
//Remove the period.
				statement = statement.trim();
				String lastChar = statement.substring(statement.length() - 1);
			if (lastChar.equals("."))
				{
					statement = statement.substring(0, statement.length() - 1);
				}
			int psn = findKeyword (statement, "I love", 0);
					String restOfStatement = statement.substring(psn + 6).trim();
			return "Why do you love " + restOfStatement + "?";
		}
//Understand why one likes something and if the bot can join in. Emotion can alter.
	private String transformILoveToStatement(String statement)
		{
// Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement.length() - 1);
			if (lastChar.equals("."))
				{
					statement = statement.substring(0, statement.length() - 1);
				}
			int psn = findKeyword (statement, "I love to", 0);
					String restOfStatement = statement.substring(psn + 9).trim();
			return "Would you like to " + restOfStatement + " with me?";
		}
	private int findKeyword(String statement, String goal,int startPos)
		{
				String phrase = statement.trim().toLowerCase();
				goal = goal.toLowerCase();
	//The only change to incorporate the startPos is in the line below
		int psn = phrase.indexOf(goal, startPos);
	//Making sure the goal isn't part of the word.
		while (psn >= 0)
			{
	//Find the string of length 1 before and after the word
				String before = " ", after = " ";
		if (psn > 0)
				{
					before = phrase.substring(psn - 1, psn);
				}
		if (psn + goal.length() < phrase.length())
				{
					after = phrase.substring(psn + goal.length(),psn + goal.length() + 1);
				}
	//If before and after aren't letters, we've found the word
		if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
	//before is not a letter
				{
				return psn;
				}
	//The last position didn't work, so let's find the next, if there is one.
				psn = phrase.indexOf(goal, psn + 1);
			}
				return -1;
		}
	private int findKeyword(String statement, String goal)
		{
				return findKeyword (statement, goal, 0);
		}
	private String getRandomResponse ()
		{
				Random r = new Random ();
				if (emotion == 0)
					{
						return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];
					}
				if (emotion < 0)
					{
						return randomAngryResponses [r.nextInt(randomAngryResponses.length)];
					}
						return randomHappyResponses [r.nextInt(randomHappyResponses.length)];
		}
	private String [] randomNeutralResponses = 
	{
		"Interesting, tell me more",
		"Hmmm.",
		"Do you really think so?",
		"What does the USSR stand for?",
		"It's all a fantasy.",
		"Would you like some sickles and hammers??",
		"Which country of the USSR was your favorite? Mine was Russia."
	};
	private String [] randomAngryResponses = 
	{
		"You're mean!",
		"Why do you hate communism so much!",
		"The rage consumes me!"
	};
	private String [] randomHappyResponses = 
	{
		"I hope Communism works in the end",
		"Life is going to be great!",
		"You make me feel like Karl Marx is in front of me!"
	};
}
