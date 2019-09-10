/**
 * Card.java
 * Represents a single Set card in the deck,
 * attributes and all
 * 
 * @author Rory Bennett
 */
import java.awt.*;


public class Card{
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

	private int x;		//The x-coordinate of a Card's upper-left corner
	private int y;		//The y-coordinate of a Card's upper-left corner

	private boolean highlighted;
	
	private boolean hint;

	public static final int RED = 1;
	public static final int GREEN = 2; 
	public static final int BLUE = 3;

	public static final int RECT = 1;
	public static final int ELLIPSE = 2;
	public static final int TRIANGLE = 3;

	public static final int SOLID = 1;
	public static final int EMPTY = 2;
	public static final int STRIPED = 3;

	public static final int WIDTH = 40;
	public static final int HEIGHT = 69;

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
		highlighted = false;
		hint = false;
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
		x = x_coor;					//Sets the x-coordinate of this Card
		y = y_coor;					//Sets the y-coordinate of this Card
		Color savedColor = page.getColor();
		page.setColor(Color.white);
		page.fillRect(x, y, WIDTH, HEIGHT);

		if (highlighted == true) {
			page.setColor(Color.red);
			page.drawRect(x,  y, WIDTH, HEIGHT);
			page.drawRect(x - 1,  y - 1, WIDTH + 2, HEIGHT + 2);
			page.drawRect(x - 2,  y - 2, WIDTH + 4, HEIGHT + 4);
		} 
		if (hint == true) {
			page.setColor(Color.blue);
			page.drawRect(x,  y, WIDTH, HEIGHT);
			page.drawRect(x - 1,  y - 1, WIDTH + 2, HEIGHT + 2);
			page.drawRect(x - 2,  y - 2, WIDTH + 4, HEIGHT + 4);
		} else {
			page.setColor(Color.black);
			page.drawRect(x,  y, WIDTH, HEIGHT);
		}

		take_Color(page);
		page.setColor(savedColor);
	}

	/**
	 * Helper method for drawing this Car's shape(s)
	 * onto its surface. Sets the page's coor appropriately,
	 * for each of the Card's shapes' color.
	 * 
	 * @param: page the page on which this Card is to be drawn
	 */
	private void take_Color(Graphics page) {

		if (color == RED) {
			page.setColor(Color.red);
		} else if (color == GREEN) {
			page.setColor(Color.green);
		} else {
			page.setColor(Color.blue);
		}

		take_Shapes(page);
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
	 */
	private void take_Shapes(Graphics page) {
		Color page_color = page.getColor();
		int count1 = 1;
		int count2 = 2;
		int count3 = 3;

		if (shape == RECT) {
			if (count == count1 || count == count3) {
				s1 = new Rect(x + 15, y + 27, SHAPE_WIDTH, SHAPE_HEIGHT, page_color);
			} 
			if (count == count2 || count == count3) {
				s2 = new Rect(x + 15, y + 6, SHAPE_WIDTH, SHAPE_HEIGHT, page_color);
				s3 = new Rect(x + 15, y + 48, SHAPE_WIDTH, SHAPE_HEIGHT, page_color);
			}
		} else if (shape == ELLIPSE) {
			if (count == count1 || count == count3) {
				s1 = new Ellipse(x + 15, y + 27, SHAPE_WIDTH, SHAPE_HEIGHT, page_color);
			} 
			if (count == count2 || count == count3){
				s2 = new Ellipse(x + 15, y + 6, SHAPE_WIDTH, SHAPE_HEIGHT, page_color);
				s3 = new Ellipse(x + 15, y + 48, SHAPE_WIDTH, SHAPE_HEIGHT, page_color);
			}
		} else {

			if (count == count1 || count == count3) {
				int[] x1 = {x + 15 + (SHAPE_WIDTH/2), x + 15, x + 15 + SHAPE_WIDTH};
				int[] y1 = {y + 19 + (SHAPE_WIDTH/2), y + 10 + (SHAPE_HEIGHT * 2), y + 10 + (SHAPE_HEIGHT * 2)};
				s1 = new Triangle(x1, y1, 3, page_color);
			} 
			if (count == count2 || count == count3) {
				int[] x2 = {x + 15 + (SHAPE_WIDTH/2), x + 15, x + 15 + SHAPE_WIDTH};
				int[] y2 = {y + 5, y + 5 + SHAPE_HEIGHT, y + 5 + SHAPE_HEIGHT};
				int[] x3 = {x + 15 + (SHAPE_WIDTH/2), x + 15, x + 15 + SHAPE_WIDTH};
				int[ ]y3 = {y + 25 + (SHAPE_WIDTH * 2), y + 15 + (SHAPE_HEIGHT * 3), y + 15 + (SHAPE_HEIGHT * 3)};
				s2 = new Triangle(x2, y2, 3, page_color);
				s3 = new Triangle(x3, y3, 3, page_color);
			}
		}
	}

	/**
	 * Return true if the Rect contains Point p, false otherwise.
	 * 
	 * @param p point tested for containment
	 */
	public boolean containsPoint(Point p) {
		return (p.x >= x && p.x <= (x + WIDTH)
				&& p.y >= y && p.y <= (y + HEIGHT));
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setHighlighted() {
		highlighted = true;
	}
	
	public void unsetHighlighted() {
		highlighted = false;
	}
	
	public void setHint() {
		hint = true;
	}
	
	public void unsetHint() {
		hint = false;
	}
}
