/**
 * Triangle.java
 * Class for a Triangle
 * 
 * Written by Rory, 16 February 2017
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
			  int minx = Math.min(minx1,  x_coords[2]);
			  int miny = Math.min(y_coords[0], y_coords[1]);
			  int height = Math.max(y_coords[0],  y_coords[1]) - miny;
			  int i = 0;		//To calculate ever-decreasing x-coordinate
			  int j = miny;		//To calculate ever-increasing y-coordinate
			  while (j < height) {
				  page.drawLine(minx + i, j, ((i * -1) * 2) + minx, j);
				  i = i - 2;
				  j += 3;
			  }
		  }
	  }
}