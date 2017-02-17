import java.awt.*;
import java.util.ArrayList;

/**
 * BackwardCmd.java
 * Command class for cycling decreasingly through the sets found in
 * the current cards at play.
 * 
 * @author Shinell Manwaring
 * @see Command
 */

public class BackwardCmd extends Command {
  private ArrayList<Card> setOfThree; // The three cards, which make a set
  
  /**
   * When the backward arrow button is clicked, display the previously seen set that exists
   * within the cards at play. If there are no more sets to display, clicking the backward
   * button shouldn't change the last set highlighted.
   * 
   * @param dwg the drawing 
   */
  public void executeClick(Drawing dwg) {
	  
	  
  }
}