import java.util.Random;

public class AvedisianChatBot {
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.<<<<<<< HEAD

		int c = 0; //im using an integer to define a path for the conversation to follow based on user input.
		int emotion = 0;
		/**
		 * Get a default greeting 	
		 * @return a greeting
		 */	
		public String getGreeting()
		{
			return "So, you hate communism, huh?";
		}
		
		/**
		 * Gives a response to a user statement
		 * 
		 * @param statement
		 *            the user statement
		 * @return a response based on the rules given
		 */
		public String getResponse(String statement)
		{
			statement = statement.toLowerCase();  // kill any bugs caused by case sensitivity
			String response = "";	
		if(c==0)
		{
			if (statement.length() == 0)
			{
				response = "Talk to me brother, youu mustn't dissent then be silent.";
			}
			if (findKeyword(statement, "yes") >= 0)
			{
				response = "Tell me, is your arguement rooted in the politics or economics?";
				c=1;
			}
			if (findKeyword(statement, "no") >= 0)
			{
				response = "Well then why would you be talking to me?";
	                	emotion=-1;
			}
			
			if (findKeyword(statement, "stalin") >= 0)
			{
				response = "Stalin? He is my hero.";
				emotion=1;
			}
			if (findKeyword(statement, "marx") >= 0)
			{
				response = "Marx the magnificent, am I right?.";
				emotion=1;
			}
			if (findKeyword(statement, "i want to") >= 0)
			{
				response = transformIWantToStatement(statement);
			}
			if (findKeyword(statement, "i want") >= 0)
			{
				response = transformIWantStatement(statement);
			}
			if ((findKeyword(statement, "geez") >= 0)||(findKeyword(statement, "wow") >= 0)||(findKeyword(statement, "whoa") >= 0)||(findKeyword(statement, "man") >= 0)) //the bot is intended to sound aggressive
			{
				response = "Dont be surprised, my job isn't to comfort you its to defend mother Russia from people like you.";
			}
			else
			{
				response = getRandomResponse();
			}
			return response;
		}
		if(c==1)
		{
			if (statement.length() == 0)
			{
				response = "I haven't all day.";
			}
			if ((findKeyword(statement, "no") >= 0)||(findKeyword(statement, "yes") >= 0))
			{
				response = "Stop wasting my time";
	                	emotion=-1;
			}
			if (findKeyword(statement, "politics") >= 0)
			{
				response = "Well then let's discuss politics! Are you familiar with the subject?";
	            c = 3;
			}
			if (findKeyword(statement, "economics") >= 0)
			{
				response = "Well then let's discuss economics! Are you familiar with the subject?";
	            c = 2;
			}
			else
			{
				response = getRandomResponse();
			}
			return response;
		}
		if(c==2)
		{
			if (findKeyword(statement, "") >= 0)
			{
				response = "One more time and I'm finished!";
			}
			if (findKeyword(statement, "no") >= 0)
			{
				response = "Then I would recommend you visit my friend Neutral Bot, he can loan you some information so that you can know all the facts.";
			}
			if (findKeyword(statement, "yes") >= 0)
			{
				response = "Well then you should know that sharing is caring and we all should have equal wealth.";
			}
			else
			{
				response = getRandomResponse();
			}
			return response;
		}
		if(c==3)
		{
			if (findKeyword(statement, "") >= 0)
			{
				response = "One more time and I'm finished!";
			}
			if (findKeyword(statement, "no") >= 0)
			{
				response = "Then I would recommend you visit my friend Neutral Bot, he can loan you some information so that you can know all the facts.";
			}
			if (findKeyword(statement, "yes") >= 0)
			{
				response = "Then you should know that Communism helps prevent corruption in our government.";
			}
			else
			{
				response = getRandomResponse();
			}
			return response;
		}
		return response;
}
		
		
		
		
		
		
		//public static boolean isBad(String statement)
		//{
		//	statement = statement.toLowerCase();
		//	if((findKeyword(statement, "i dislike") >= 0)||(findKeyword(statement, "is bad") >= 0)||(findKeyword(statement, "hate") >= 0)||
		//	   (findKeyword(statement, "communism sucks") >= 0)||(findKeyword(statement, "economics") >= 0)
		//			
		//			);
		//}
		
		
		
		
		
		
		
		
		
		
		/**
		 * Take a statement with "I want to <something>." and transform it into 
		 * "Why do you want to <something>?"
		 * @param statement the user statement, assumed to contain "I want to"
		 * @return the transformed statement
		 */
		
		private String transformIWantToStatement(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			int psn = findKeyword (statement, "i want to", 0);
			String restOfStatement = statement.substring(psn + 9).trim();
			return "Dont tell me that you want to " + restOfStatement + ", I have no interest in your desires.";
		}

		
		
		private String transformIsBad(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			int psn = findKeyword (statement, "is bad", 0);
			String restOfStatement = statement.substring(psn + 6).trim();
			return "Why do you think " + restOfStatement + "is bad?";
		}
		
		
		
		/**
		 * Take a statement with "I want <something>." and transform it into 
		 * "Would you really be happy if you had <something>?"
		 * @param statement the user statement, assumed to contain "I want"
		 * @return the transformed statement
		 */
		private String transformIWantStatement(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			int psn = findKeyword (statement, "i want", 0);
			String restOfStatement = statement.substring(psn + 6).trim();
			return "Why would I care that you want " + restOfStatement + "? I'm not your shrink.";
		}
		
		
		/**
		 * Take a statement with "I <something> you" and transform it into 
		 * "Why do you <something> me?"
		 * @param statement the user statement, assumed to contain "I" followed by "you"
		 * @return the transformed statement
		 */
		private String transformIYouStatement(String statement)
		{
			//  Remove the final period, if there is one
			statement = statement.trim();
			String lastChar = statement.substring(statement
					.length() - 1);
			if (lastChar.equals("."))
			{
				statement = statement.substring(0, statement
						.length() - 1);
			}
			
			int psnOfI = findKeyword (statement, "i", 0);
			int psnOfYou = findKeyword (statement, "you", psnOfI);
			
			String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
			return "Why should I care that you " + restOfStatement + " me? Stay on topic.";
		}
		

		
		
		/**
		 * Search for one word in phrase. The search is not case
		 * sensitive. This method will check that the given goal
		 * is not a substring of a longer string (so, for
		 * example, "I know" does not contain "no").
		 *
		 * @param statement
		 *            the string to search
		 * @param goal
		 *            the string to search for
		 * @param startPos
		 *            the character of the string to begin the
		 *            search at
		 * @return the index of the first occurrence of goal in
		 *         statement or -1 if it's not found
		 */
		private int findKeyword(String statement, String goal,
				int startPos)
		{
			String phrase = statement.trim().toLowerCase();
			goal = goal.toLowerCase();

			// The only change to incorporate the startPos is in
			// the line below
			int psn = phrase.indexOf(goal, startPos);

			// Refinement--make sure the goal isn't part of a
			// word
			while (psn >= 0)
			{
				// Find the string of length 1 before and after
				// the word
				String before = " ", after = " ";
				if (psn > 0)
				{
					before = phrase.substring(psn - 1, psn);
				}
				if (psn + goal.length() < phrase.length())
				{
					after = phrase.substring(
							psn + goal.length(),
							psn + goal.length() + 1);
				}

				// If before and after aren't letters, we've
				// found the word
				if (((before.compareTo("a") < 0) || (before
						.compareTo("z") > 0)) // before is not a
												// letter
						&& ((after.compareTo("a") < 0) || (after
								.compareTo("z") > 0)))
				{
					return psn;
				}

				// The last position didn't work, so let's find
				// the next, if there is one.
				psn = phrase.indexOf(goal, psn + 1);

			}

			return -1;
		}
		
		/**
		 * Search for one word in phrase.  The search is not case sensitive.
		 * This method will check that the given goal is not a substring of a longer string
		 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
		 * @param statement the string to search
		 * @param goal the string to search for
		 * @return the index of the first occurrence of goal in statement or -1 if it's not found
		 */
		private int findKeyword(String statement, String goal)
		{
			return findKeyword (statement, goal, 0);
		}
		


		/**
		 * Pick a default response to use if nothing else fits.
		 * @return a non-committal string
		 */
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
		
		private String [] randomNeutralResponses = {"Psssssssssshhhhhhhh",
				"I don't know what to say.",
				"Redistribution, am I right?",
				"Ah.",
				"You can say that again! Although I'd rather you not."
		};
		private String [] randomAngryResponses = {"The Cremlin will have your head!", "You are nothing to me!", "You'll pay for your actions...", "You bring me great discontent."};
		private String [] randomHappyResponses = {"You please me comrade.", "A thousand years of Communism!", "Down with the West!"};
}
