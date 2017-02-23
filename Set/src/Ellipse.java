import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen 
 * @see Shape
 */
public class Ellipse extends Shape {
  private int left, top; // left and top of Ellipse
  private int width, height; // Ellipse's height and width

  /**
   * Constructor just saves the parameters in the instance variables.
   * 
   * @param left x coordinate of the top-left corner
   * @param top y coordinate of the top-left corner
   * @param width the width
   * @param height the height
   * @param color the color
   */
  public Ellipse(int l, int t, int w, int h, Color color) {
    super(color);
    left = l;
    top = t;
    width = w;
    height = h;
  }
  
  public void setX(int x) {
	  left = x;
  }
  
  public void setY(int y) {
	  top = y;
  }
  
  public void setWidth(int w) {
	  width = w;
  }
  
  public void setHeight(int h) {
	  height = h;
  }

  /**
   * Have the Ellipse draw itself. Checks 
   * whether it should be solid, empty,or striped.
   *
   * @param page the page you wish to draw on
   * @param shading the opcode to determine the
   * kind of shading of this Shape
   */
  public void drawShape(Graphics page, int shading) {
	  if (shading == Card.SOLID || shading == Card.STRIPED) {
		page.fillOval(left, top, width, height);
	  } else if (shading == Card.EMPTY) {
		  page.drawOval(left,  top,  width,  height);
	  }
	  
	  if (shading == Card.STRIPED) {
		  page.setColor(Color.white);
		  int j = top;
		  while (j < top + height) {
			  page.drawLine(left, j, left + width, j);
			  j += 3;
		  }
	  }
  }

  /**
   * Return true if the Ellipse contains Point p, false otherwise.
   * 
   * @param p point tested for containment
   */
  public boolean containsPoint(Point p) {
	  return pointInEllipse(p, left, top, width, height);
  }

  // Helper method that returns whether Point p is in an Ellipse with the given
  // top left corner and size.
  private static boolean pointInEllipse(Point p, int left, int top, int width,
      int height) {
    double a = width / 2.0; // half of the width
    double b = height / 2.0; // half of the height
    double centerx = left + a; // x-coord of the center
    double centery = top + b; // y-coord of the center
    double x = p.x - centerx; // horizontal distance between p and center
    double y = p.y - centery; // vertical distance between p and center

    // Now we just apply the standard geometry formula.
    // (See CRC, 29th edition, p. 178.)
    return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
  }

  /**
   * Have the Ellipse move itself.
   * 
   * @param deltaX new x coordinate
   * @param deltaY new y coordinate
   */
  public void move(int deltaX, int deltaY) {
    left += deltaX;
    top += deltaY;
  }

  /**
   * Return the Ellipse's center.
   * 
   * @return the center of the Ellipse
   */
  public Point getCenter() {
    return new Point(left + (width / 2), top + (height / 2));
  }
}
