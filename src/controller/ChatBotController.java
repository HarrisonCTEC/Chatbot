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
	 * Starts the Chatbot Application.
	 */
	public void start()
	{
		String message = JOptionPane.showInputDialog(null, "Whould you like to continue?");
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
