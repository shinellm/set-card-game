import java.awt.*;

public class Rect extends Shape{
	private int x, y;
	private int height, width;
	public Rect(int x_coor, int y_coor, int w, int h, Color c) {
		super(c);
		x = x_coor;
		y = y_coor;
		width = w;
		height = h;
	}
	
	  /**
	   * Have the Rect draw itself. Checks for whether
	   * it should be solid, empty, or striped.
	   *
	   * @param page the page you wish to draw on 
	   * @param shading the style in which the Shape is to be drawn
	   */
	  public void drawShape(Graphics page, int shading) {
		  if (shading == Card.SOLID || shading == Card.STRIPED) {
			page.fillRect(x, y, width, height);
		  } else if (shading == Card.EMPTY) {
			  page.drawRect(x,  y,  width,  height);
		  }
		  
		  if (shading == Card.STRIPED) {
			  page.setColor(Color.white);
			  int j = y;
			  while (j < y + height) {
				  page.drawLine(x, j, x + width, j);
				  j += 3;
			  }
		  }
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
	  
	  public void setWidth(int w) {
		  width = w;
	  }
	  
	  public void setHeight(int h) {
		  height = h;
	  }
}