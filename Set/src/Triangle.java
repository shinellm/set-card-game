/**
 * Triangle.java
 * Class for a Triangle
 * 
 * @author Rory Bennett
 */
import java.awt.*;
import java.util.Arrays;
import java.lang.Math;

public class Triangle extends Shape {
	private int num_points;
	private int[] x_coords;
	private int[] y_coords;
	
	//Sets the triangle three Points via the int arrays
	  public Triangle(int[] x, int[] y, int np, Color color) {
		    super(color);
		    x_coords = Arrays.copyOf(x, 3);
		    y_coords = Arrays.copyOf(y, 3);
		    num_points = np;
		  }
	  
	  /**
	   * Have the Triangle draw itself. Checks for whether
	   * it should be solid, empty, or striped.
	   * 
	   * @param page the page you wish to draw on
	   * @param shading the opcode to determine the
	   * kind of shading of this Shape
	   */
	  public void drawShape(Graphics page, int shading) {
		  if (shading == Card.SOLID || shading == Card.STRIPED) {
			page.fillPolygon(x_coords, y_coords, num_points);
		  } else if (shading == Card.EMPTY) {
			  page.drawPolygon(x_coords, y_coords, num_points);
		  }
		  
		  if (shading == Card.STRIPED) {
			  page.setColor(Color.white);
			  int minx1 = Math.min(x_coords[0], x_coords[2]);
			  int minx = Math.min(minx1,  x_coords[1]);
			  int maxx1 = Math.max(x_coords[0], x_coords[1]);
			  int maxx = Math.max(maxx1, x_coords[2]);
			  int miny1 = Math.min(y_coords[0], y_coords[1]);
			  int miny = Math.min(miny1, y_coords[2]);
			  int maxy1 = Math.max(y_coords[0], y_coords[1]);
			  int maxy = Math.max(maxy1, y_coords[2]);
			  int j = miny;		//To calculate ever-increasing y-coordinate
			  while (j < maxy) {
				  page.drawLine(minx, j, maxx, j);
				  j += 3;
			  }
		  }
	  }
}
