//Ava DiPietro
public class IsCommunist {
	
	BansalChatBot chatbot1 = new BansalChatBot();
	AvedisianChatBot chatbot2 = new AvedisianChatBot();
	DiPietroChatBot chatbot3 = new DiPietroChatBot();
	
	public int isCommunist(String statement) {		
		int comOpinion = 0;
		
		//To check opinion on communism
		
		if (findKeyword(statement, "nope") >= 0) {
			comOpinion = -1;
		}
		else if (findKeyword(statement, "no") >= 0) {
			comOpinion = -1;
		}
		else if (findKeyword(statement, "not") >= 0) {
			comOpinion = -1;
		}
		else if (findKeyword(statement, "don't") >= 0) {
			if (findKeyword(statement, "know") >= 0) {
				comOpinion = 0;
			}
			else {
				comOpinion = -1;
			}
		}
		else if (findKeyword(statement, "yes") >= 0) {
			comOpinion = 1;
		}
		else if (findKeyword(statement, "yeah") >= 0) {
			comOpinion = 1;
		}
		else if (findKeyword(statement, "like") >= 0) {
			comOpinion = 1;
		}
		else if (findKeyword(statement, "do") >= 0) {
			comOpinion = 1;
		}
		else if (findKeyword(statement, "love") >= 0) {
			comOpinion = 1;
		}
		
		return comOpinion;
	}
	
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


}
