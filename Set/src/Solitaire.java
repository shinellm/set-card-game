
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Solitaire extends Mode {
	private static final long serialVersionUID = 1L;
	private Command cmd;
	private Drawing d;
	private Container c;
	
	
	/**
	 * Constructor 
	 * @param cp the container object 
	 * @param dwg	the drawing object
	 */
	public Solitaire(Drawing dwg, Container cp) {
		super(dwg, cp);
		this.setSelectThreeCards(true);
		cmd = new Command();
		d = dwg;
		c = cp;
	
		//Make JButton objects 
		JButton hintButton = new JButton("Hint");
		JButton add3CardsButton = new JButton("Add 3 Cards");
				
		//Add listeners to buttons
		hintButton.addActionListener(new HintButtonListener());
		add3CardsButton.addActionListener(new Add3CardsButtonListener());
		
		JPanel optionPanel = this.optionPanel;
		optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
		hintButton.setBackground(Color.cyan);
		add3CardsButton.setBackground(Color.cyan);
		optionPanel.add(hintButton);
		optionPanel.add(Box.createRigidArea(new Dimension(0,5)));
		optionPanel.add(add3CardsButton);
		optionPanel.setBackground(Color.white);
		
		c.add(optionPanel, BorderLayout.EAST);
		c.repaint();
		c.validate();
		
	}
	
	
	private class HintButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new HintCmd();
			cmd.executeClick(d);
			c.repaint();
		}
	}
		
	private class Add3CardsButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new AddThreeCmd();
			cmd.executeClick(d);
			c.repaint();
			} 
	}
	
}
