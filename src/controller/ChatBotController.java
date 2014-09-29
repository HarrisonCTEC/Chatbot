package controller;

import javax.swing.JOptionPane;

import model.Chatbot;
import view.ChatBotView;

public class ChatBotController
{
	private ChatBotView appView;
	private Chatbot notSoCleverBot;
	
	/**
	 * Creates a ChatbotAppController and initializes the associated View and Model objects.
	 */
	public ChatBotController()
	{
		appView = new ChatBotView(this);
		notSoCleverBot = new Chatbot("Mr. not so clever");
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
		String message = JOptionPane.showInputDialog(null, "Welcome to Chatbot, type in your name.");
		
		while(!notSoCleverBot.quitChecker(message))
		{
			message = appView.displayChatbotConversation(message);
		}
		if(notSoCleverBot.quitChecker(message))
		{
			quit();
		}
		
		JOptionPane.showMessageDialog(null, "We are not done yet...");
	}

	private void quit()
	{
		JOptionPane.showMessageDialog(null,  "bye");
		System.exit(0);
	}
}
