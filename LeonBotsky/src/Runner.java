import java.util.Scanner;

public class Runner 
{
	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		BansalChatBot chatbot1 = new BansalChatBot();
		AvedisianChatBot chatbot2 = new AvedisianChatBot();
		DiPietroChatBot chatbot3 = new DiPietroChatBot();
		
		IsCommunist checker = new IsCommunist();
		String statement = "";
		Scanner in = new Scanner (System.in);
		int notBye = 0;
		
		System.out.println ("Hi! I'm Leon Botsky. Do you like communism by any chance?");
		statement = in.nextLine();
		
	while(!statement.equals("end program")) {
		if (notBye == 1) {
			
			//Process for choosing a new bot after initial bot is told "bye"
			statement = "not bye";
			System.out.println("Choose a new bot by typing its corresponding number.");
			System.out.println("1 - For those who are neutral");
			System.out.println("2 - For those who hate communism");
			System.out.println("3 - For those who love communism");
			System.out.println("Or, type 'end program' to leave.");
			statement = in.nextLine();
		}
		while ((!statement.toLowerCase().equals("bye")) && (!statement.equals("end program")))
	{	
		String botChoice = statement;
		
		//Uses the person's opinion on communism to refer them to the respective bot
		if ((checker.isCommunist(statement) == -1) || (botChoice.equals("2"))) {
			
			System.out.println (chatbot2.getGreeting());
			statement = in.nextLine();
			
			while ((!statement.toLowerCase().equals("bye")) && (!statement.equals("end program")))
			{
				System.out.println (chatbot2.getResponse(statement));
				statement = in.nextLine();
			}
		}
		
		else if ((checker.isCommunist(statement) == 1) || (botChoice.equals("3"))) {
			
			System.out.println (chatbot3.getGreeting());
			statement = in.nextLine();
			// reuses method to see if user wants to take quiz
			if (checker.isCommunist(statement) == 1) {
				chatbot3.beginQuiz();
				statement = in.nextLine();
			}
			else {
				System.out.println (chatbot3.getGreeting2());
				statement = in.nextLine();
			}
			
			while ((!statement.toLowerCase().equals("bye")) && (!statement.equals("end program")))
			{
				System.out.println (chatbot3.getResponse(statement));
				statement = in.nextLine();
			}
		}
		
		else {
			
			System.out.println (chatbot1.getGreeting());
			statement = in.nextLine();
			
			while ((!statement.toLowerCase().equals("bye")) && (!statement.equals("end program")))
			{
				System.out.println (chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}

	}
		System.out.println("Goodbye, my brother.");
		notBye = 1;
	}
	}
}