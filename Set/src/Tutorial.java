/**
 * Tutorial Mode
 * 
 * @author Elizabeth Ricci
 * @see Mode.java
 */

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

import java.util.ArrayList;


public class Tutorial extends Mode {
	private static final long serialVersionUID = 1L;
	private Command cmd;
	private Drawing d;
	private Container c;

	
	/**
	 * Constructor 
	 * @param cp the container object
	 * @param dwg the drawing object 
	 */
	public Tutorial(Drawing dwg, Container cp){
		super(dwg, cp);
		setSelectThreeCards(false);
		cmd = new Command();
		d = dwg;
		c = cp;
		
		//Make JButton objects for the two modes of play
		JButton forwardButton = new JButton("Next Set");
		JButton backwardButton = new JButton("Previous Set");
		JButton next12Button = new JButton("Next 12 Cards");
		
				
		//Add listeners to the two Modes subclass buttons
		forwardButton.addActionListener(new ForwardButtonListener());
		backwardButton.addActionListener(new BackwardButtonListener());
		next12Button.addActionListener(new Next12ButtonListener());
				
		//The two buttons will be adjacent to one another, in one row of two
		JPanel optionPanel = new JPanel(); //Holds the buttons horizontally
		optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
		forwardButton.setBackground(Color.cyan);
		backwardButton.setBackground(Color.cyan);
		next12Button.setBackground(Color.cyan);
		optionPanel.add(Box.createRigidArea(new Dimension(0,10)));
		optionPanel.add(forwardButton);
		optionPanel.add(Box.createRigidArea(new Dimension(0,5)));
		optionPanel.add(backwardButton);
		optionPanel.add(Box.createRigidArea(new Dimension(0,5)));
		optionPanel.add(next12Button);
		optionPanel.setBackground(Color.white);
		
				
		c.add(optionPanel, BorderLayout.EAST);
		c.repaint();
		c.validate();
	}

	private class ForwardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new ForwardCmd();
			cmd.executeClick(d);
			c.repaint();
			
		}
	}
	
	private class BackwardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new BackwardCmd();
			cmd.executeClick(d);
			c.repaint();
			
			
		}
	}
	
	private class Next12ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new NewTwelveCardsCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
}
