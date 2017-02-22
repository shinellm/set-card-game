import java.awt.Point;
import java.util.ArrayList;


/**
 * Command.java
 * Superclass for commands.
 * Provides empty definitions for the executeClick method.
 * 
 * @author Shinell Manwaring
 */
public class Command {
	ArrayList<Card> threeCards = new ArrayList<Card>();
  public void executeClick(Drawing dwg) { }
  
	public void addToSet(Drawing dwg, Point p) {}
}

