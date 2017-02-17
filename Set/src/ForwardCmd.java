import java.awt.*;
import java.util.ArrayList;

/**
 * ForwardCmd.java
 * Command class for cycling increasing through the sets found in
 * the current cards at play.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class ForwardCmd extends Command {
  private ArrayList<Card> setOfThree; // The three cards, which make a set
  
  /**
   * When the forward arrow button is clicked, display another set that exists
   * within the cards at play. If there are no more sets to display, clicking the forward
   * button shouldn't change the last set highlighted.
   * 
   * @param dwg the drawing 
   */
  public void executeClick(Drawing dwg) {
	  
	  
  }
}