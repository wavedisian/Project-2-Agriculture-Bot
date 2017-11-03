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
		
	while(!statement.equals("Bye"))
	{	
		System.out.println ("Hi! I'm Leon Botsky. Do you like communism by any chance?");
		Scanner in = new Scanner (System.in);
		statement = in.nextLine();
		
		//Uses the person's opinion on communism to refer them to the respective bot
		
		if (checker.isCommunist(statement) == -1) {
			
			System.out.println (chatbot2.getGreeting());
			statement = in.nextLine();
			
			while (!statement.equals("Bye"))
			{
				System.out.println (chatbot2.getResponse(statement));
				statement = in.nextLine();
			}
		}
		
		else if (checker.isCommunist(statement) == 1) {
			
			System.out.println (chatbot3.getGreeting());
			statement = in.nextLine();
			
			while (!statement.equals("Bye"))
			{
				System.out.println (chatbot3.getResponse(statement));
				statement = in.nextLine();
			}
		}
		
		else {
			
			System.out.println (chatbot1.getGreeting());
			statement = in.nextLine();
			
			while (!statement.equals("Bye"))
			{
				System.out.println (chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}

	}
		System.out.println("Goodbye, my brother.");
	}
	
}
