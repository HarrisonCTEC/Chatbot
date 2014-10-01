package view;

import javax.swing.JOptionPane;

import controller.ChatBotController;

public class ChatBotView
{
	
	private ChatBotController baseController;
	
	public ChatBotView(ChatBotController baseController)
	{
		this.baseController = baseController;
	}
	
	/**
	 * Displays the supplied String parameter to the user via popup and returns the user's response to the controller.
	 * @param input The supplied text to be displayed.
	 * @return The user's input
	 */
	public String displayChatbotConversation(String input)
	{
		String output = "";
		
		output = JOptionPane.showInputDialog(null, input);
		
		return output;
	}
	
	/**
	 * Displays the supplied input via a popup window.
	 * @param input The text to be displayed
	 */
	public void displayInformation(String input)
	{
		JOptionPane.showMessageDialog(null, input);
	}
}
