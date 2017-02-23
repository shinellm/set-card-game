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
	private static final long serialVersionUID = 1L;private Drawing dwg;
	private Command cmd;

	
	/**
	 * Constructor 
	 * @param cp the container object
	 * @param dwg the drawing object 
	 */
	public Tutorial(Drawing dwg, Container cp){
		super(dwg, cp);
		cmd = new Command();
		
		//Make JButton objects for the two modes of play
		JButton forwardButton = new JButton("Previous Set");
		JButton backwardButton = new JButton("Next Set");
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
		
				
		cp.add(optionPanel, BorderLayout.EAST);
		cp.repaint();
		cp.validate();
	}

	private class ForwardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button0 = (JButton)event.getSource();
			JPanel panel = (JPanel)button0.getParent();
			Component [] components = panel.getComponents();
			JButton button1 = (JButton)components[1];
			
		}
	}
	
	private class BackwardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button0 = (JButton)event.getSource();
			JPanel panel = (JPanel)button0.getParent();
			Component [] components = panel.getComponents();
			JButton button1 = (JButton)components[0];
			
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
