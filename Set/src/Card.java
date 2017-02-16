/**
 * Card.java
 * Represents a single Set card in the deck,
 * attributes and all
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Card extends JPanel implements ActionListener{
	private int count;
	private int color;		//number code for Card's specific color
	private int shading;	//number code for Card's specific shade pattern
	private int shape;		//number code for Card's specific shape
	
	private final int WIDTH = 40;
	private final int HEIGHT = 70;
	public Card(int cou, int col, int shad, int shap) {
		count = cou; 
		color = col;
		shading = shad;
		shape = shap;
		this.setSize(WIDTH, HEIGHT);
		this.setBackground(Color.white);
	}
	
	/**
	 * 
	 */
	public void draw(int cou, int col, int shad, int shap) {
		
	}
}