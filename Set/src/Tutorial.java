/**
 * Tutorial Mode
 * 
 * @author Elizabeth Ricci
 * @see Mode.java
 */

import java.awt.*;
import java.awt.event.*;

import javax.smartcardio.Card;
import javax.swing.*;

import java.util.ArrayList;


public class Tutorial extends Mode {

	private Drawing dwg;
	private Command cmd;
	private Container cp;
	private int multiArrIndex;
	private ArrayList<ArrayList<Card>> allSets= new ArrayList<ArrayList<Card>>();
	
	/**
	 * Constructor 
	 * @param cp the container object
	 * @param dwg the drawing object 
	 */
	public Tutorial(Drawing d, Container c){
		super(dwg, cp);
		cmd = new Command();
		dwg = d;
		cp = c;
		multiArrIndex = 0;
		
		//Make JButton objects for the two modes of play
		JButton forwardButton = new JButton("Previous Set");
		JButton backwardButton = new JButton("Next Set");
		JButton next12Button = new JButton("Next 12 Cards");
		
		backwardButton.setEnabled(false);	//Cannot allow the user to try and call negative indices in the array
				
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
			JButton button0 = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			Component [] components = panel.getComponents();
			JButton button1 = (JButton)components[1];
			
			if ((multiArrIndex - 1) >= 0) {
				for (int i = 0; i < 3; i++) {
					allSets.get(multiArrIndex - 1).get(i).unhighlight();
				}
			}
			
				button1.setEnabled(true);
				cmd = new ForwardCmd(allSets.get(multiArrIndex));
				cmd.executeClick(dwg);
				multiArrIndex += 1;
				repaint();
			
			if (multiArrIndex == (allSets.size() - 1)) {
				button0.setEnabled(false);
			}
		}
	}
	
	private class BackwardButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button0 = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			Component [] components = panel.getComponents();
			Jbutton button1 = (JButton)components[0];
			
			if ((multiArrIndex + 1) <= (allSets.size() - 1)) {
				for (int i = 0; i < 3; i++) {
					allSets.get(multiArrIndex + 1).get(i).unhighlight();
				}
			}
			
				button1.setEnabled(true);
				cmd = new BackwardCmd(allSets.get(multiArrIndex));
				cmd.executeClick(dwg);
				multiArrIndex = multiArrIndex - 1;
				repaint();
			
			if (multiArrIndex == 0) {
				button0.setEnabled(false);
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
