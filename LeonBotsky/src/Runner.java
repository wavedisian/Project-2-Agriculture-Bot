
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
		
		System.out.println (chatbot1.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		


		while (!statement.equals("Bye"))
		{
			System.out.println (chatbot1.getResponse(statement));
			statement = in.nextLine();
		}
		System.out.println("Goodbye my brother")
	}
}
