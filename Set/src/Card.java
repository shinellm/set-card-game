/**
 * Card.java
 * Represents a single Set card in the deck,
 * attributes and all
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Card implements ActionListener{
	private int color;		//number code for Card's specific color: 1 = Red, 
								//2 = Green, 3 = Blue
	private int shape;		//number code for Card's specific shape: 1 = Rect,
								//2 = Ellipse, 3 = Triangle
	private int count;
	private int shading;	//number code for Card's specific shade pattern: 1 = Solid,
								//2 = Empty, 3 = Triangle
	
	private Shape s1; 	//The actual shape(s) to be drawn on this Card object
	private Shape s2;
	private Shape s3
	
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
		page.fillRect(x_coor, y_coor, WIDTH, HEIGHT);
		draw_Shapes1(page, x_coor, y_coor)
	}
	
	/**
	 * Helper method for drawing this Car's shape(s)
	 * onto its surface. 
	 * 
	 * @param: page the page on which this Card is to be drawn
	 * @param: x_coor the x-coordinate of this Card, to then determine
	 * the coordinates of the Shape(s)
	 * @param: y_coor the y-coordinate of this Card, to then determine
	 * the coordinates of the Shape(s)
	 */
	private void draw_Shapes1(Graphics page, x_coor, y_coor) {
		Color savedColor = page.getColor();
		
		if (color == 1) {
			page.setColor(Color.red);
		} else if (color == 2) {
			page.setColor(Color.green);
		} else {
			page.setColor(Color.blue);
		}
		
		draw_Shapes2(page, x_coor, y_coor);
		
		page.setColor(savedColor);
	}
	
	private void draw_Shapes2 (Graphics page, x_coor, y_coor){
		if (shape == 1) {
			s = new Rect()
		}
		
		setShading(s1, s2, s3);
	}
	
	private void setShading (Shape sh1, Shape sh2, Shape sh3) {
		
	}
}