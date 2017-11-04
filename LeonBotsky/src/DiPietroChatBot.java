import java.util.Random;
import java.util.Scanner;

public class DiPietroChatBot {
	Scanner in = new Scanner (System.in);
	String statement = "";
	//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.
		int emotion = 0;
		/**
		 * Get a default greeting 	
		 * @return a greeting
		 */	
		public String getGreeting()
		{
			return "Ah, a comrade! Would you like to test your knowledge on communism?";
		}
		public String getGreeting2()
		{
			return "That's a shame. I guess we can just chat. Tell me about yourself :)";
		}
		public void beginQuiz()
		{
			int score = 0;
			//QUESTION 1
			System.out.println("What country was the first to become officially communist?");
			statement = in.nextLine();
			if (statement.toLowerCase().equals("russia")) {
				score = score + 20;
				System.out.println("Correct! Next question.");
			}
			else {
				System.out.println("Sorry, but the correct answer is Russia. Next question.");
			}
			//QUESTION 2
			System.out.println("Whose book 'Das Kapital' paved the way for Communism?");
			statement = in.nextLine();
			if ((statement.toLowerCase().equals("karl marx")) || (statement.toLowerCase().equals("marx"))) {
				score = score + 20;
				System.out.println("Correct! Next question.");
			}
			else {
				System.out.println("Sorry, but the correct answer is Karl Marx. Next question.");
			}
			//QUESTION 3
			System.out.println("Who was the first leader of the Soviet Union?");
			statement = in.nextLine();
			if ((statement.toLowerCase().equals("vladimir lenin")) || (statement.toLowerCase().equals("lenin"))) {
				score = score + 20;
				System.out.println("Correct! Next question.");
			}
			else {
				System.out.println("Sorry, but the correct answer is Vladimir Lenin. Next question.");
			}
			//QUESTION 4
			System.out.println("In which year did the Soviet Union dissolve?");
			statement = in.nextLine();
			if (statement.toLowerCase().equals("1991")) {
				score = score + 20;
				System.out.println("Correct! Next question.");
			}
			else {
				System.out.println("Sorry, but the correct answer is 1991. Next question.");
			}
			//QUESTION 5
			System.out.println("What is the only currently communist country not in Asia?");
			statement = in.nextLine();
			if (statement.toLowerCase().equals("cuba")) {
				score = score + 20;
				System.out.println("Correct! Next question.");
			}
			else {
				System.out.println("Sorry, but the correct answer is Cuba.");
			}
			if (score <= 40) {
				System.out.println("You scored " + score + "%. You should learn more about communism!");
			}
			else if (score == 60) {
				System.out.println("You scored " + score + "%. Nice.");
			}
			else if (score >= 80) {
				System.out.println("You scored " + score + "%. A true коммунист!");
			}
			System.out.println("Shall we go back to chatting?");
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
			String response = "";
			
			if (statement.length() == 0)
			{
				response = "Quit Stalin and type something!";
			}

			else if (findKeyword(statement, "no") >= 0)
			{
				response = "Cheer up. There's always hope for a revolution!";
	                	emotion--;
			}
			
			else if (findKeyword(statement, "thank you") >= 0)
			{
				response = "You're welcome!";
	                	emotion++;
			}
			
			else if (findKeyword(statement, "capitalism") >= 0)
			{
				response = "Capitalism? More like crapitalism.";
	                	emotion--;
			}
			
			else if (findKeyword(statement, "revolution") >= 0)
			{
				response = "DOWN WITH THE BOURGEOISIE";
	                	emotion++;
			}
			
			else if (findKeyword(statement, "levin") >= 0)
			{
				response = "More like pleasegiveus100 amiright?";
				emotion++;
			}
			if (findKeyword(statement, "you") >= 0)
			{
				response = "ME???";
			}

			// Response transforming I want to statement
			else if (findKeyword(statement, "I want to", 0) >= 0)
			{
				response = transformIWantToStatement(statement);
			}
			else if (findKeyword(statement, "I want",0) >= 0)
			{
				response = transformIWantStatement(statement);
			}
			else if (findKeyword(statement, "I hate", 0) >= 0)
			{
				response = transformIHateStatement(statement);
			}
			else
			{
				response = getRandomResponse();
			}
			
			return response;
		}
		
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
			int psn = findKeyword (statement, "I want to", 0);
			String restOfStatement = statement.substring(psn + 9).trim();
			return "Why do you want to " + restOfStatement + "?";
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
			int psn = findKeyword (statement, "I want", 0);
			String restOfStatement = statement.substring(psn + 6).trim();
			return capitalizeLetter(restOfStatement) + " sounds nice, but I want a revolution.";
		}
		
		//capitalizes first letter of a substring
		private String capitalizeLetter(String statement)
		{
			return (statement.substring(0, 1)).toUpperCase() + statement.substring(1);
			
		}
		private String transformIHateStatement(String statement)
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
			int psn = findKeyword (statement, "I hate", 0);
			String restOfStatement = statement.substring(psn + 6).trim();
			return capitalizeLetter(restOfStatement) + " is better than capitalism!";
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
		
		private String [] randomNeutralResponses = {
				"I know, right?",
				"Interesting.",
				"If you put it that way...",
				"I love talking to you.",
				"I'm shook.",
				"You're so knowledgable.",
				"Tell me more about yourself."
		};
		private String [] randomAngryResponses = {
				"What???", 
				"Ew...", 
				"Sounds capitalist...",
				"You're really Putin me down."
				};
		private String [] randomHappyResponses = {
				"Radical!", 
				"Sharing is caring, you know.", 
				"#winning",
				"Я люблю коммунизм!"
				};
}
