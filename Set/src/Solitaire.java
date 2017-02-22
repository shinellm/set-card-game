/**
 * Solitaire mode.
 * 
 * @author Elizabeth Ricci
 * @see Mode.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Solitaire extends Mode {
	


	private Drawing dwg;
	private Command cmd;
	private Container cp;
	private int cardsClicked = 0;
	
	
	/**
	 * Constructor 
	 * @param cp the container object 
	 * @param dwg	the drawing object
	 */
	public Solitaire(Drawing d, Container c) {
		super(dwg, cp);
		cmd = new Command();
		dwg = d;
		cp = c;
		CanvasPanel canvasPanel = new CanvasPanel();
		canvasPanel.setBackground(Color.white);
		
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
				
		cp.add(optionPanel, BorderLayout.NORTH);
		cp.add(canvasPanel, BorderLayout.CENTER);
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
	
	private int getCardsClicked(){
		return 0;
	}
	
	/** 
	   * CanvasPanel is the class upon which we actually draw.  It listens
	   * for mouse events and calls the appropriate method of the current
	   * command. (From Project 1)
	   */ 
	  protected class CanvasPanel extends JPanel implements MouseListener,
	      MouseMotionListener {
	    private static final long serialVersionUID = 0;
	    
	    /**
	     * Constructor just needs to set up the CanvasPanel as a listener.
	     */
	    public CanvasPanel() {
	      addMouseListener(this);
	      addMouseMotionListener(this);
	    }

	    /**
	     * Paint the whole drawing
	     * @page the Graphics object to draw on
	     */
	    public void paintComponent(Graphics page) {
	      super.paintComponent(page); // execute the paint method of JPanel
	      dwg.draw(page); // have the drawing draw itself
	    }

	    /**
	     * When the mouse is clicked, call the executeClick method of the
	     * current command.
	     */
	    public void mouseClicked(MouseEvent event) {
	    	if (cardsClicked == 0) {
	    		cmd = new SelectThreeCardsCmd();
	    	}
	    		cmd.addToSet(dwg, event.getPoint());
	    		repaint();
	    		cardsClicked += 1;
	    	if (cardsClicked == 3) {
	    		cardsClicked = 0;
	    	}
	    }

	    // We don't care about the other mouse events.
	    public void mouseDragged(MouseEvent event) { }
	    public void mousePressed(MouseEvent event) { }
	    public void mouseReleased(MouseEvent event) { }
	    public void mouseEntered(MouseEvent event) { }
	    public void mouseExited(MouseEvent event) { }
	    public void mouseMoved(MouseEvent event) { }
	  }
}
