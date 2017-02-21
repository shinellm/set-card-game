/**
 * A facade that the client interacts with, delegates 
 * to subclasses, Solitaire and Tutorial to
 * run specified mode.
 *  
 * @author Elizabeth Ricci
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mode {

	private Drawing dwg;
	private Container cp;
	private Command cmd;
	protected Canvas canvas;
	
	/**
	 * Default constructor.
	 * 
	 *  @param dwg a drawing object
	 *  @param cp a container object
	 */
	public Mode(Drawing dwg, Container cp){
		dwg = this.dwg;
		cp = this.cp;
		cmd = new Command();
		
		//Make JButton objects for the two modes of play
		JButton homeButton = new JButton("Home");
		JButton restartButton = new JButton("Restart");
		
		//Add listeners to the two Modes subclass buttons
		homeButton.addActionListener(new HomeButtonListener());
		restartButton.addActionListener(new RestartButtonListener());
		
		//The two buttons will be adjacent to one another, in one row of two
		JPanel optionPanel = new JPanel(); //Holds the buttons horizontally
		optionPanel.setLayout(new FlowLayout());
		homeButton.setBackground(Color.green);
		restartButton.setBackground(Color.green);
		optionPanel.add(homeButton);
		optionPanel.add(restartButton);
		
		cp.add(optionPanel, BorderLayout.CENTER);
		
		// The cards will appear in a CanvasPanel.
	    canvas = new Canvas();
	    canvas.setBackground(Color.blue);
		
	}
	
	private class HomeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			cmd = new QuitCmd();
		}
	}
		
	private class RestartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton)event.getSource();
			JPanel panel = (JPanel)button.getParent();
			panel.remove(0);
			panel.remove(0);
			panel.repaint();
			panel.validate();
			Container cp = (Container)panel.getParent();
			cp.remove(0);
			cmd = new RestartCmd();
			}
	}
	
	
	

}
