
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Solitaire extends Mode {
	private static final long serialVersionUID = 1L;private Drawing dwg;
	private Command cmd;
	
	/**
	 * Constructor 
	 * @param cp the container object 
	 * @param dwg	the drawing object
	 */
	public Solitaire(Drawing dwg, Container cp) {
		super(dwg, cp);
		cmd = new Command();
		
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
		
		cp.add(optionPanel, BorderLayout.WEST);
	}
	
	
	private class HintButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new HintCmd();
			cmd.executeClick(dwg);
			repaint();
		}
	}
		
	private class Add3CardsButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new AddThreeCmd();
			cmd.executeClick(dwg);
			repaint();
			} 
	}
	
}
