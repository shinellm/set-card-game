/**
 * HomePage.java
 * Initial page for an object-oriented GUI
 * for playing Set.
 * 
 * Written for CSC-260 Project 2
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JApplet {
	private static final long serialVersionUID = 1L;
	
	private final int APPLE_WIDTH = 700, APPLET_HEIGHT = 500;
	private Drawing dwg;
	private Mode mode;
	
	/**
	 * Sets up the first two buttons, with which the user
	 * will choose a specific mode to play.
	 */
	public void init() {
		dwg = new Drawing();
		mode = new Mode();
		GameZone gamezone= new GameZone();
		gamezone.setBackground(Color.white);
		
		//Make JButton objects for the two modes of play
		JButton tutorialButton = new JButton("Tutorial");
		JButton solitaireButton = new JButton("Solitaire");
		
		//Add listeners to the two Modes subclass buttons
		tutorialButton.addActionListener(new TutorialButtonListener());
		solitaireButton.addActionListener(new SolitaireButtonListener());
		
		//The two buttons will be adjacent to one another, in one row of two
		JPanel modePanel = new JPanel; //Holds the buttons horizontally
		modePanel.setLayout(new FlowLayout());
		tutorialButton.setBackground(Color.green);
		solitaireButton.setBackground(Color.green);
		modePanel.add(tutorialButton);
		modePanel.add(solitaireButton);
		
		//Container objects enable control of the location of panels
		//contained within it.
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(modePanel, BorderLayout.CENTER);
		
		setSize(APPLET_WIDTH, APPLET_HEIGHT);
	}
	
	private class TutorialButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			mode = new Tutorial(dwg);
			repaint();
		}
	}
	
	private class SolitaireButtonListener implements ActionListener {
		publci void actionPerformed(ActionEvent event) {
			mode = new Solitaire(dwg);
			repaint();
		}
	}
	
	/**
	 * Table represents the "table" upon which 
	 * the game is played. It listens for mouse
	 * events and calls the appropriate method of
	 * the current command.
	 */
	private class GameZone extends JPanel implements MouseListener, 
	MouseMotionListener {
		private static final long serialVersionUID = 0;
		
		/**
		 * Constructor just needs to set up the Table as a listener
		 */
		public GameZone() {
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
	      cmd.executeClick(event.getPoint(), dwg);
	      repaint();
	    }
	    
	    //We don't care about these
	    public void mousePressed(MouseEvent event) { }
	    public void mouseDragged(MouseEvent event) { }
	    public void mouseReleased(MouseEvent event) { }
	    public void mouseEntered(MouseEvent event) { }
	    public void mouseExited(MouseEvent event) { }
	    public void mouseMoved(MouseEvent event) { }
	}
}