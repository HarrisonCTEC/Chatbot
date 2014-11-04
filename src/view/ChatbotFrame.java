package view;

import javax.swing.JFrame;

import controller.ChatBotController;

public class ChatbotFrame extends JFrame
{
	private ChatbotPanel basePanel;
	public ChatbotFrame(ChatBotController baseController)
	{
		basePanel = new ChatbotPanel(baseController);
		setupFrame();
	}
	
	/**
	 * Setup the options of the window.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}
