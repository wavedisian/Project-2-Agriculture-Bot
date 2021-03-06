// Saurabh Bansal
import java.util.Random;
public class Information 
{
	int emotion = 0;
	String response = "";
	public String info(String statement)
	{
		//Used to find all the key questions based on communism
		if (((findKeyword(statement, "karl marx")) >= 0) || 
				((findKeyword(statement, "marx")) >= 0))
			{
				response = "Go to http://www.history.com/topics/karl-marx and you can read all about him!";
				emotion = 1;
			}
		else if (((findKeyword(statement, "soviet union")) >= 0) || 
				((findKeyword(statement, "ussr")) >= 0))
			{
				response = 	"Go to http://www.history.com/topics/history-of-the-soviet-union "
						+ "and you can read all about it!";
				emotion = 1;
			}
		else if ((findKeyword(statement, "russian revolution")) >= 0 || 
				(findKeyword(statement, "How did Communism come to be so big during the Cold War")) >= 0)
			{
				response = "Go to http://www.csun.edu/~kaddison/kraus.htm "
						+ "and you can read all about it! It's a simple site with alot of information.";
				emotion = 1;
			}
		else if ((findKeyword(statement, "what is communism")) >= 0)
			{
				response = "The best website with all the information about Communism is"
						+ "https://www.britannica.com/topic/communism! Read all about it!";
				emotion = 1;
			}
		else if ((findKeyword(statement, "lenin")) >= 0)
			{
				response = "Read http://econfaculty.gmu.edu/bcaplan/museum/hisfram1.htm to read about Lenin and the first "
						+ "communist revolutionaries!";
				emotion = 1;
			}
		else if ((((findKeyword(statement, "world war 2") >= 0) || (findKeyword(statement, "ww2")) >= 0)) && 
				(findKeyword(statement, "communism")) >= 0)
		{
			response = "Read about how Communism spread in Eastern Europe through "
					+ "https://www.theatlantic.com/international/archive/2012/10/how-communism-took-over-eastern-europe-after-world-war-ii/263938/";
			emotion = 1;
		}
		else if ((findKeyword(statement, "history") >= 0) && (findKeyword(statement, "communism") >= 0))
		{
			response = "Look at https://www.britannica.com/topic/Communist-Party-of-the-Soviet-Union to learn about the Communism in Russia.";
			emotion = 1;
		}
		else if ((findKeyword(statement, "communist countries") >= 0) && (findKeyword(statement, "today") >= 0))
		{
			response = "China, Cuba, Laos, North Korea, Vietnam. "
					+ "Nepal, Guyana, and Moldova have all had ruling communist parties in recent years. "
					+ "While the world has just five communist countries, "
					+ "socialist countries are relatively common countries whose constitutions include statements about "
					+ "the protection and rule of the working class. Socialist states include Portugal, Sri Lanka, India, "
					+ "Guinea-Bissau, and Tanzania.";
			emotion = 1;
		}
		
		else {
			response = "Hmm... I don't have any specific information about that. Maybe try something else?";
		}
		return response;
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
				"Which country of the USSR was your favorite? Mine was Albania."
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

