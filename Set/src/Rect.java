import java.awt.*;

public class Rect extends Shape{
	private int x, y;
	private final int height = 20;
	private final int width = 10;
	public Rect(int x_coor, int y_coor, Color c) {
		super(c);
		x = x_coor;
		y = y_coor;
	}
	
	  /**
	   * Have the Rect draw itself.
	   *
	   * @param page the page you wish to draw on
	   */
	  public void drawShape(Graphics page) {
			page.fillRect(x, y, width, height);
	  }

	  /**
	   * Return true if the Rect contains Point p, false otherwise.
	   * 
	   * @param p point tested for containment
	   */
	  public boolean containsPoint(Point p) {
		  return (p.x >= x && p.x <= (x + width)
				  && p.y >= y && p.y <= (y + height));
	  }
	  
	  /**
	   * Have the Rect move itself.
	   * 
	   * @param deltaX new x coordinate
	   * @param deltaY new y coordinate
	   */
	  public void move(int deltaX, int deltaY) {
		    x += deltaX;
		    y += deltaY;
	  }
	  
	  /**
	   * Return the Rect's center.
	   * 
	   * @return the center of the Rect
	   */
	  public Point getCenter(){
		  return new Point(x + (width / 2), y + (height / 2));
	  }
	  
	  public void setX(int x_coor) {
		  x = x_coor;
	  }
	  
	  public void setY(int y_coor) {
		  y = y_coor;
	  }
}