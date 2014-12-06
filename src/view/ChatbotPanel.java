package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
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
	
	/**
	 * Setup the main panel
	 * @param baseController
	 */
	public ChatbotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;
		sampleButton = new JButton("Click");
		sampleField = new JTextField(25);
		chatArea = new JTextArea(5, 25);
		chatPane =  new JScrollPane(chatArea);
		baseLayout = new SpringLayout();

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
		this.setLayout(baseLayout);
		this.add(sampleButton);
		this.add(sampleField);
		this.add(chatPane);

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
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 282, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 94, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleField, -28, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.EAST, sampleField, -100, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, -248, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 45, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 52, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -44, SpringLayout.NORTH, sampleField);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -67, SpringLayout.EAST, this);
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
	
	/**
	 * Append text to chat area
	 * @param input text to show to user.
	 */
	public void displayTextToUser(String input)
	{
		chatArea.append(input + '\n');
		chatArea.setCaretPosition(chatArea.getDocument().getLength());
	}
}
