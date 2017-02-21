/**
 * Tutorial Mode
 * 
 * @author Elizabeth Ricci
 * @see Mode.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Tutorial extends Mode {

	private Drawing dwg;
	private Command cmd;
	private int multiArrIndex;
	
	/**
	 * Constructor 
	 * @param cp the container object
	 * @param dwg the drawing object 
	 */
	public Tutorial(Drawing dwg, Container cp){
		super(dwg, cp);
		cmd = new Command();
		multiArrIndex = 0;
		
		//Make JButton objects for the two modes of play
		JButton forwardButton = new JButton("Previous Set");
		JButton backwardButton = new JButton("Next Set");
		JButton next12Button = new JButton("Next 12 Cards");
		
		backwardButton.setEnable(false);	//Cannot allow the user to try and call negative indices in the array
				
		//Add listeners to the two Modes subclass buttons
		forwardButton.addActionListener(new ForwardButtonListener());
		backwardButton.addActionListener(new BackwardButtonListener());
		next12Button.addActionListener(new Next12ButtonListener());
				
		//The two buttons will be adjacent to one another, in one row of two
		JPanel optionPanel = new JPanel(); //Holds the buttons horizontally
		optionPanel.setLayout(new FlowLayout());
		forwardButton.setBackground(Color.green);
		backwardButton.setBackground(Color.green);
		next12Button.setBackground(Color.green);
		optionPanel.add(forwardButton);
		optionPanel.add(backwardButton);
		optionPanel.add(next12Button);
				
		cp.add(optionPanel, BorderLayout.NORTH);
	}

	
	
	private class ForwardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new ForwardCmd();
			cmd.executeClick(dwg);
			multiArrIndex += 1;
			repaint();
			}
	}
	
	private class BackwardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			
			if (index >= 1) {
				button.setEnable(true);
				cmd = new BackwardCmd();
				cmd.executeClick(dwg);
				multiArrIndex = multiArrIndex - 1;
				repaint();
			}
		}
	}
	
	private class Next12ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new NewTwelveCardsCmd();
			cmd.executeClick(dwg);
			repaint();
			}
	}
}
