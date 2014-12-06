package model;

import java.util.ArrayList;
import model.User;

public class Chatbot
{
	/**
	 * The name of the Chatot
	 */
	private String name;
	/**
	 * The current number of chats that chatbot has participated in
	 */
	private int numberOfChats;
	/**
	 * The List of memes used in the chatbot
	 */
	private ArrayList<String> memeList;
	/**
	 * A list of input from the user to be used within the program.
	 */
	private ArrayList<String> userInputList;
	
	private User myUser;
	
	/**
	 * Creates a Chatbot object with a specified name. Initializes the total chats to 0.
	 * @param name The name of the Chatbot.
	 */
	public Chatbot(String name)
	{
		this.name = name;
		// this. means talk to the current class
		numberOfChats = -1;
		
		myUser = new User();
		
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
	
	private boolean userInputChecker(String input)
	{
		boolean matchesInput = false;
		
		if(userInputList.size() > 0)
		{
			for(int loopCount = 0; loopCount < userInputList.size(); loopCount++)
			{
				if(input.equalsIgnoreCase(userInputList.get(loopCount)))
				{
					matchesInput = true;
					userInputList.remove(loopCount);
					loopCount--;
				}
			}
		}
		
		return matchesInput;
	}
	
	/**
	 * Process the supplied text from the user to provide a message from the Chatbot.
	 * @param userText The user supplied text.
	 * @return What the Chatbot says because of the supplied input.
	 */
	public String processText(String userText)
	{
		String processedText = "";
		
		int randomChoice = (int) (Math.random() * 4);
		if (userText != null)
		{
			if(numberOfChats == 0)
			{
				myUser.setName(userText);
				processedText = "Hello " + myUser.getName() + " what is your age?";
			}
			else if(numberOfChats == 1)
			{	
				try
				{
				int age = Integer.parseInt(userText);
				myUser.setAge(age);
				processedText = "Hello " + myUser.getAge() + " you are really " + myUser.getAge() + " years old?";
				processedText += "\nWhat is your favorite movie?";
				}
				catch (Exception e)
				{
					processedText = "That's not a number :(";
				}
			}
			else
			{
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
				else if (randomChoice ==2)
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
				else if (randomChoice == 4)
				{
					userInputList.add(0, userText);
				}
				else if (randomChoice == 5)
				{
					if(chatbotNameChecker(userText))
					{
						processedText = chatbotNameConversation(userText);
					}
					else
					{
						processedText = noNameConversation(userText);
					}
				}
				else
				{
					//userInputChecker
				}
					
				
			}
		}
		incrementChats();
		return processedText;
	}
	
	/**
	 * Checks to see if the name of the Chatbot is contained within the String supplied by the user
	 * @param input The user supplied String
	 * @return Whether the name is inside or not
	 */
	private boolean chatbotNameChecker(String input)
	{
		boolean hasNameInString = false;
		
		if(input.indexOf(this.getName()) > -1)
		{
			
		}
		
		return hasNameInString;
	}
	
	private String chatbotNameConversation(String input)
	{
		String nameConversation = "This is whay you typed after my name: ";
		
		nameConversation.concat(input.substring(input.indexOf(this.getName()), input.length()-1));
		
		return nameConversation;
	}
	
	private String noNameConversation(String currentInput)
	{
		String notNamed = "";
		
		int smallRandom = (int) (Math.random() * currentInput.length()/2);
		int largerRandom = (int) (smallRandom + (Math.random() * (currentInput.length() / 2) + 1));
		
		notNamed = "You didn't say my name so here is a special phrase: " + currentInput.substring(smallRandom, largerRandom);
		
		return notNamed;
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
