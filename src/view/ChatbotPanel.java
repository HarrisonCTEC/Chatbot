package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.ChatBotController;

import javax.swing.JTextPane;
import javax.swing.JLabel;

public class ChatbotPanel extends JPanel
{
	private ChatBotController baseController;
	
	private JButton sampleButton;
	private JTextField sampleField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private SpringLayout baseLayout;
	
	public ChatbotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;
		sampleButton = new JButton("Click");
		sampleField = new JTextField(25);
		chatPane =  new JScrollPane();
		
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 282, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 94, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleField, -28, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.EAST, sampleField, -100, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, -248, SpringLayout.EAST, this);


		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}

	/**
	 * Set up the panel options.
	 */
	private void setupPanel()
	{
		//this.setBackground(Color.MAGENTA);
		this.setLayout(baseLayout);
		
		this.add(sampleButton);
		this.add(sampleField);
		this.add(chatPane);
		chatArea = new JTextArea(5, 25);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 45, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 52, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -44, SpringLayout.NORTH, sampleField);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -67, SpringLayout.EAST, this);
		add(chatArea);
	}
	
	/**
	 * Set the scroll pane options.
	 */
	private void setupScrollPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}

	/**
	 * Setup the layout by running all the code from the design view.
	 */
	private void setupLayout()
	{
		
	}

	/**
	 * Set up the button press listeners.
	 */
	private void setupListeners()
	{
		sampleButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String userTypedText = sampleField.getText();
				String chatbotResponse = baseController.sendTextToChatBot(userTypedText);
				displayTextToUser(userTypedText);
				displayTextToUser(chatbotResponse);
				sampleField.setText("");
			}
		});
		
	}
	
	public void displayTextToUser(String input)
	{
		chatArea.append(input + '\n');
	}
}
