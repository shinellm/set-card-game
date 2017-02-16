/**
 * Card.java
 * Represents a single Set card in the deck,
 * attributes and all
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Card implements ActionListener{
	private int count;
	private int color;		//number code for Card's specific color
	private int shading;	//number code for Card's specific shade pattern
	private int shape;		//number code for Card's specific shape
	
	private int x;		//x-coordinate of the Card's upper-left corner
	private int y; 		//y-coordinate of the Card's upper-left corner
	
	private final int WIDTH = 40;
	private final int HEIGHT = 70;
	public Card(int cou, int col, int shad, int shap) {
		count = cou; 
		color = col;
		shading = shad;
		shape = shap;
	}
	
	/**
	 * Draws a white rectangle, given the x- and y-coordinate
	 * parameters, and the set width and height instance variables.
	 * Then uses its other instance variables, determined at the 
	 * instantiation of the Deck object in which it is held, to 
	 * draw the shapes, the coordinates of which will be based
	 * off of this Card's own coordinates.
	 * 
	 * @param: page the page on which this Card is to be drawn
	 * @param: x_coor the x-coordinate of this Card
	 * @param: y_coor the y-coordinate of this Card
	 */
	public void draw(Graphics page, int x_coor, int y_coor) {
		Color savedColor = page.getColor();
		page.fillRect(x_coor, y_coor, WIDTH, HEIGHT);
		
	}
}