import java.awt.*;

/**
 * Shape.java
 * Abstract class for geometric shapes.
 * Provides three non-abstract methods: setColor, draw, and setCenter.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 */
public abstract class Shape {
  private Color color; // Shape's color

  public abstract void drawShape(Graphics page, int shade); // draw the Shape
 // public abstract boolean containsPoint(Point p); // does the Shape contain Point p?
  //public abstract void move(int deltaX, int deltaY); // move the Shape
  //public abstract Point getCenter(); // return the Shape's center
  
  /**
   * Create a Shape, setting its color. 
   * 
   * @param c the color you wish the shape to initially have
   */
  public Shape(Color c) {
    color = c;
  }

  /**
   * Set the Shape's color.
   * 
   * @param newColor the new color of the shape
   */
  public void setColor(Color newColor) {
    color = newColor;
  }
  
  /**
   * Draw the Shape.
   * 
   * @param page the page you wish to draw the shape on
   * @param shading the style in which the Shape is to be drawn
   */
  public void draw(Graphics page, int shading) {
	Color savedColor = page.getColor();
	page.setColor(color);
	drawShape(page, shading);
	page.setColor(savedColor);
  }
}