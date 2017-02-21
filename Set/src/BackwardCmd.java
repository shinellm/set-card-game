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
  private ArrayList<Card> setOfThree = new ArrayList<Card>(); // The three cards, which make a set
  
  /**
   * Creates a private arrayList of three cards, which make a set.
   * 
   * @param arr an ArrayList of cards, which make a set 
   */
  public BackwardCmd(ArrayList<Card> arr) {
	  for (int i = 0; i < 3; i++) {
		  setOfThree.add(i, arr.get(i));
	  }
  }
  
  /**
   * When the backward arrow button is clicked, display the previously seen set that exists
   * within the cards at play. If there are no more sets to display, clicking the backward
   * button shouldn't change the last set highlighted.
   * 
   * @param dwg the drawing 
   */
  public void executeClick(Drawing dwg) {
	  for (int i = 0; i < setOfThree.size(); i++) {
		  int tracker = compareForIndex(setOfThree.get(i));
		  dwg.getCard(tracker).highlight();
	  }
  }
}