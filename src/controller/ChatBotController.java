package controller;

import model.Chatbot;
import model.User;
import view.ChatBotView;
import view.ChatbotFrame;
import view.ChatbotPanel;

public class ChatBotController
{
	/**
	 * The GUI view for the application.
	 */
	private ChatBotView appView;
	
	/**
	 * The Chatbot Model instance.
	 */
	private Chatbot notSoCleverBot;
	
	/**
	 * The startup message for our chatbot application.
	 */
	private String startMessage;
	
	private ChatbotFrame baseFrame;
	
	private User user;
	
	/**
	 * Creates a ChatbotAppController and initializes the associated View and Model objects.
	 */
	public ChatBotController()
	{
		appView = new ChatBotView(this);
		baseFrame = new ChatbotFrame(this);
		notSoCleverBot = new Chatbot("Mr. not so clever");
		startMessage = "Welcome to the " + notSoCleverBot.getName() + " Chatbot, type in your name.";
	}
	
	/**
	 * Allows other objects access to the notSoCleverbot. 
	 * @return The Chatbot for this app.
	 */
	public Chatbot getNotSoCleverBot()
	{
		return notSoCleverBot;
	}
	
	/**
	 * Starts the Chatbot Application.
	 */
	public void start()
	{
		//String message = appView.displayChatbotConversation(startMessage);
		
		String message = "";
		
		
		ChatbotPanel myAppPanel = (ChatbotPanel) baseFrame.getContentPane();
		myAppPanel.displayTextToUser(startMessage);
		
		
		
		message = notSoCleverBot.processText(message);
		
		
		//message = appView.displayChatbotConversation(message);

		
		//quit();
		
	}
	
	public String sendTextToChatBot(String userInput)
	{
		String response = "";
		
		response = notSoCleverBot.processText(userInput);
		
		return response;
	}
	
	/**
	 * Quits the Chatbot application with a message to the user that the application is closing.
	 */
	private void quit()
	{
		appView.displayInformation("goodbye cruel user :(");
		System.exit(0);
	}
}
