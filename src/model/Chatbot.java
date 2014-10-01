package model;

import java.util.ArrayList;

public class Chatbot
{
	private String name;
	private int numberOfChats;
	private ArrayList<String> memeList;

	
	/**
	 * Creates a Chatbot object with a specified name. Initializes the total chats to 0.
	 * @param name The name of the Chatbot.
	 */
	public Chatbot(String name)
	{
		this.name = name;
		// this. means talk to the current class
		numberOfChats = 0;
		
		memeList = new ArrayList<String>();
		fillMemeList();

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
     * Fills the meme list with memes
     */
	private void fillMemeList()
	{
		memeList.add("y u mad bro");
		memeList.add("doh!");
		memeList.add("nyan cat");
		memeList.add("velociraptor");
		memeList.add("awkward moment");
		memeList.add("memes");
	}
	
	private boolean memeChecker(String currentText)
	{
		boolean isAMeme = false;
		
		for(String currentMeme : memeList)
		{
			if(currentMeme.equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}
		
		return isAMeme;
	}
	
	/**
	 * Process the supplied text from the user to provide a message from the Chatbot.
	 * @param userText The user supplied text.
	 * @return What the Chatbot says because of the supplied input.
	 */
	public String processText(String userText)
	{
		String processedText = "";
		
		if(memeChecker(userText))
		{
			processedText = "hey, you found a meme: " + userText;
			processedText += " isn't that cool.";
		}
		else
		{
			processedText = "Boring, that wan't a meme.";
		}
		
		return processedText;
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
