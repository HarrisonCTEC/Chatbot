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
	
	public String displayChatbotConversation(String input)
	{
		String output = "";
		
		output = JOptionPane.showInputDialog(null, baseController.getNotSoCleverBot().getName() + " says hello, " + input + " do you wish to continue?");
		
		return output;
	}
}
