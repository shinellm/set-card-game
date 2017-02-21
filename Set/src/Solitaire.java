/**
 * Solitaire mode.
 * 
 * @author Elizabeth
 * @see Mode.java
 */
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Solitaire extends Mode {
	


	private Drawing dwg;
	private Command cmd;
	
	
	/**
	 * Constructor 
	 * @param cp the container object 
	 * @param dwg	the drawing object
	 */
	public Solitaire(Drawing dwg, Container cp) {
		super(dwg, cp);
		
		//Make JButton objects for the two modes of play
		JButton hintButton = new JButton("Hint");
		JButton add3CardsButton = new JButton("Add 3 Cards");
				
		//Add listeners to the two Modes subclass buttons
		hintButton.addActionListener(new HintButtonListener());
		add3CardsButton.addActionListener(new Add3CardsButtonListener());
				
		//The two buttons will be adjacent to one another, in one row of two
		JPanel optionPanel = new JPanel(); //Holds the buttons horizontally
		optionPanel.setLayout(new FlowLayout());
		hintButton.setBackground(Color.green);
		add3CardsButton.setBackground(Color.green);
		optionPanel.add(hintButton);
		optionPanel.add(add3CardsButton);
				
		cp.add(optionPanel, BorderLayout.CENTER);
		
		
	}
	
	
	private class HintButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			cmd = new HintCmd();
		}
	}
		
	private class Add3CardsButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			cmd = new AddThreeCmd();
			}
	}
	
	
	
	/**
	 * Adds three cards to play upon request
	 */
	public void addThreeCards(){
		
	}
	
	/**
	 * Replace cards when 3 are removed
	 */
	public void replaceThreeCards(){
		
	}
	
	/**
	 * ????
	 */
	public void paintComponent(){
		
	}
	
	private int getCardsClicked(){
		return 0;
	}
	
	private void actionPerformed(){
		
	}
	

	

}
