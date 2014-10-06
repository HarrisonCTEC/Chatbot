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
	
	/**
	 * Checks to see if the supplied user text matches any of the memes in the Chatbot's meme list.
	 * @param currentText The user supplied text.
	 * @return Whether the String matched any of the built memes.
	 */
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
	 * Checks to see if the supplied user text is less than or equal to 5 characters.
	 * @param input The user's typed text
	 * @return if the string is less than or equal to 5
	 */
	private boolean stringLengthChecker(String input)
	{
		boolean shortString = false;
		
		if(input.length() <= 5)
		{
			shortString = true;
		}
		
		return shortString;
	}

	/**
	 * Process the supplied text from the user to see if it contains the subject.
	 * @param input The user's typed text
	 * @param subject The text to search for.
	 * @return If the input contains the subject.
	 */
	private boolean contentChecker(String input, String subject)
	{
		boolean containsSubject = false;
		
		if(input.contains(subject))
		{
			containsSubject = true;
		}
		
		return containsSubject;
	}
	
	/**
	 * Process the supplied text from the user to provide a message from the Chatbot.
	 * @param userText The user supplied text.
	 * @return What the Chatbot says because of the supplied input.
	 */
	public String processText(String userText)
	{
		String processedText = "";
		incrementChats();
		
		int randomChoice = (int) Math.random() * 3;
		
		if (randomChoice == 0)
		{
			if(stringLengthChecker(userText))
			{
				processedText = "You're not very talkative are you?";
			}
			else
			{
				processedText = "And how does that make you feel?";
			}
		}
		else if (randomChoice == 1)
		{
			if(contentChecker(userText, "Harrison"))
			{
				processedText = "Don't talk about my creator like that!";
			}
			else
			{
				processedText = "Hmm, I see...";
			}
		}
		else
		{
			if(memeChecker(userText))
			{
				processedText = "hey, you found a meme: " + userText;
				processedText += " isn't that cool.";
			}
			else
			{
				processedText = "Boring, that wan't a meme.";
			}
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
