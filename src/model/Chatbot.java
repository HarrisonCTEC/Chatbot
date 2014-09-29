package model;

public class Chatbot
{
	private String name;
	private int numberOfChats;

	
	/**
	 * Creates a Chatbot object with a specified name. Initializes the total chats to 0.
	 * @param name The name of the Chatbot.
	 */
	public Chatbot(String name)
	{
		this.name = name;
		// this. means talk to the current class

		numberOfChats = 0;

	}

	/**
	 * Returns the chatbot's name.
	 * @return Chatbot's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the number of chats
	 * @return Number of chats
	 */
	public int getNumberOfChats()
	{
		return numberOfChats;
	}

	/**
	 * Sets the Chatbot's name.
	 * @param name Chatbot's name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Adds 1 to the number of chats.
	 */
	public void incrementChats()
	{
		numberOfChats++;
	}
	
	/**
	 * Checks if the user has asked to quit.
	 * @param input Text typed by user.
	 * @return If we should quit. True or false.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if(input != null && input.equals("good bye"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
}
