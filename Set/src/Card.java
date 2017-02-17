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
	private Shape s3;
	
	private static final int RED = 1;
	private static final int GREEN = 2; 
	private static final int BLUE = 3;
	
	private static final int RECT = 1;
	private static final int ELLIPSE = 2;
	private static final int TRIANGLE = 3;
	
	private static final int SOLID = 1;
	private static final int EMPTY = 2;
	private static final int STRIPED = 3;
	
	private int x;		//x-coordinate of the Card's upper-left corner
	private int y; 		//y-coordinate of the Card's upper-left corner
	
	private final int WIDTH = 40;
	private final int HEIGHT = 69;
	private final int SHAPE_HEIGHT = 15;
	private final int SHAPE_WIDTH = 10;
	public Card(int cou, int col, int shad, int shap) {
		count = cou; 
		color = col;
		shading = shad;
		shape = shap;
		s1 = null;
		s2 = null;
		s3 = null;
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
		page.setColor(Color.black);
		page.drawRect(x_coor,  y_coor, WIDTH, HEIGHT);
		take_Color(page, x_coor, y_coor)
		page.setColor(savedColor);
	}
	
	/**
	 * Helper method for drawing this Car's shape(s)
	 * onto its surface. Sets the page's coor appropriately,
	 * for each of the Card's shapes' color.
	 * 
	 * @param: page the page on which this Card is to be drawn
	 * @param: x_coor the x-coordinate of this Card, to then determine
	 * the coordinates of the Shape(s)
	 * @param: y_coor the y-coordinate of this Card, to then determine
	 * the coordinates of the Shape(s)
	 */
	private void take_Color(Graphics page, x_coor, y_coor) {
		
		if (color == RED) {
			page.setColor(Color.red);
		} else if (color == GREEN) {
			page.setColor(Color.green);
		} else {
			page.setColor(Color.blue);
		}
		
		take_Shapes(page, x_coor, y_coor);
		if (s1 != null) {
			s1.draw(page, shading);
		}
		if (s2 != null) {
			s2.draw(page, shading);
		}
		if (s3 != null) {
			s3.draw(page, shading);
		}
	}
	
	/**
	 * Helper method that determines which of the above Shape 
	 * instance variables are to be instantiated, and as which 
	 * Shape subclass object. 
	 * 
	 * @param: page the page on which this Card is to be drawn
	 * @param: x_coor the x-coordinate of this Card, to then determine
	 * the coordinates of the Shape(s)
	 * @param: y_coor the y-coordinate of this Card, to then determine
	 */
	private void take_Shapes(Graphics page, x_coor, y_coor) {
		Color page_color = page.getColor();
		
		if (shape == RECT) {
			if (count == (1 || 3)) {
				s1 = new Rect(x_coor + 15, y_coor + 27, WIDTH, HEIGHT, page_color);
			} 
			if (count == (2 || 3)) {
				s2 = new Rect(x_coor + 15, y_coor + 6, WIDTH, HEIGHT, page_color);
				s3 = new Rect(x_coor + 15, y_coor + 48, WIDTH, HEIGHT, page_color);
			}
		} else if (shape == ELLIPSE) {
			if (count == (1 || 3)) {
				s1 = new Ellipse(x_coor + 15, y_coor + 27, WIDTH, HEIGHT, page_color);
			} 
			if (count == (2 || 3)){
				s2 = new Ellipse(x_coor + 15, y_coor + 6, WIDTH, HEIGHT, page_color);
				s3 = new Ellipse(x_coor + 15, y_coor + 48, WIDTH, HEIGHT, page_color);
			}
		} else {
			int [] x1;  //x-coordinates of first triangle
			int [] y1;	 //y-coordinates of first triangle
			int [] x2;
			int [] y2;
			int [] x3;
			int [] y3;
			if (count == (1 || 3)) {
				x1 = {x_coor + 15 + (SHAPE_WIDTH/2), x_coor + 15, x_coor + 15 + SHAPE_WIDTH};
				y1 = {y_coor + 19 + SHAPE_WIDTH, y_coor + 19 + (SHAPE_HEIGHT * 2), y_coor + 19 + (SHAPE_HEIGHT * 2)};
				s1 = new Triangle(x1, y1, 3, page_color);
				} 
			if (count == (2 || 3)) {
					x2 = {x_coor + 15 + (SHAPE_WIDTH/2), x_coor + 15, x_coor + 15 + SHAPE_WIDTH};
					y2 = {y_coor + 9, y_coor + 9 + SHAPE_HEIGHT, y_coor + 9 + SHAPE_HEIGHT};
					x3 = {x_coor + 15 + (SHAPE_WIDTH/2), x_coor + 15, x_coor + 15 + SHAPE_WIDTH};
					y3 = {y_coor + 29 + (SHAPE_WIDTH * 2), y_coor + 29 + (SHAPE_HEIGHT * 3), y_coor + 19 + (SHAPE_HEIGHT * 3)};
					s2 = new Triangle(x2, y2, 3, page_color);
					s3 = new Triangle(x3, y3, 3, page_color);
				}
			}
		}
	
	public int getColor() {
		return color;
	}
	
	public int getShape() {
		return shape;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getShading() {
		return shading;
	}
	}