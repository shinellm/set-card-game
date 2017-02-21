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

	public Drawing dwg;
	private Command cmd;
	
	/**
	 * Constructor 
	 * @param cp the container object
	 * @param dwg the drawing object 
	 */
	public Tutorial(Drawing dwg, Container cp){
		super(dwg, cp);
		
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
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			cmd = new ForwardCmd();
			}
	}
	
	private class BackwardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			cmd = new BackwardCmd();
			}
	}
	
	private class Next12ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			cmd = new NewTwelveCardsCmd();
			}
	}
	
	
	/**
	 * 
	 */
	public void paintComponent(){
		
	}
	
	private void actionPerformed(){
		
	}
}
