import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mode extends JApplet{
	private static final long serialVersionUID = 1L;
	private Drawing dwg;
	private Container cp;
	private Command cmd;
	private SelectThreeCardsCmd selectCmd;
	private Deck deck;
	private boolean toSelectOrNot;
	private String modeName;
	protected JPanel optionPanel;
	
	public static final int canvasX = 50;		//The x-coordinate for the canvas panel, on which the cards are draw
	public static final int canvasY = 50;		//The y-coordinate for the canvas panel, on which the cards are draw
	
	/**
	 * Default constructor.
	 * 
	 *  @param dwg a drawing object
	 *  @param cp a container object
	 */
	public Mode(Drawing d, Container c){
		dwg = d;
		cp = c;
		cmd = new Command();
		selectCmd = new SelectThreeCardsCmd();
		toSelectOrNot = false;
		optionPanel = new JPanel();
		
		CanvasPanel canvasPanel = new CanvasPanel();
		canvasPanel.setBackground(Color.cyan);
		
		
		JButton restartButton = new JButton("Restart");
		JButton switchButton = new JButton("Switch Mode");
		
		restartButton.addActionListener(new RestartButtonListener());
		switchButton.addActionListener(new SwitchButtonListener());
		
		JPanel GeneralOptionPanel = new JPanel();
		GeneralOptionPanel.setLayout(new FlowLayout());
		restartButton.setBackground(Color.CYAN);
		switchButton.setBackground(Color.CYAN);
		GeneralOptionPanel.add(restartButton);
		GeneralOptionPanel.add(switchButton);
		GeneralOptionPanel.setBackground(Color.white);
		
		cp.add(GeneralOptionPanel, BorderLayout.NORTH);
		cp.add(canvasPanel, BorderLayout.CENTER);
		cp.repaint();
		cp.validate();
		
		//Create Deck
		deck = Deck.getUniqueInstance();
		//Initialize deck 
		deck.shuffle();
		
		//Add 12 cards
		for (int i = 0; i < 12; i++) {
			  Card card = deck.deal();
			  dwg.addCard(i, card);
		}
		
		modeName = this.getClass().getName();
	}

	/**
	 * Sets the instance variable toSelectOrNot to true
	 * or false based on the parameter, thus enabling
	 * or disabling the ability to select a set on the canvas.
	 * 
	 * @param: set the boolean to which toSelectOrNot will be set
	*/
	public void setSelectThreeCards(boolean set) {
		toSelectOrNot = set;
	}
	
	
		
	private class RestartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			cmd = new RestartCmd();
			cmd.executeClick(dwg);
			cp.repaint();
		}
	}
	
	private class SwitchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		
			cp.removeAll();
			cp.repaint();
			if (dwg.getHighlight() != 0) {
				dwg.clearHighlightedCards();
			}
			if (dwg.isShowingHint() == true) {
				dwg.clearHintCards();
				dwg.notShowingHint();
			}
			dwg = new Drawing();
			
			if(modeName == "Solitaire"){
				new Tutorial(dwg, cp);
			}
			else{
				new Solitaire(dwg, cp); 
			}
		}
	}
	
	
	/** 
	   * CanvasPanel is the class upon which we actually draw.  It listens
	   * for mouse events and calls the appropriate method of the current
	   * command. (From Project 1)
	   */ 
	  private class CanvasPanel extends JPanel implements MouseListener,
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
		if (toSelectOrNot) {
	    		Point p = event.getPoint();
	    		selectCmd.addToSet(dwg, p);
	    		repaint();
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
